package com.tgb.json.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.mchange.v1.util.SetUtils;
import com.tgb.model.User;
import com.tgb.service.UserService;
import com.tgb.util.GenerateUtil;
import com.tgb.util.JdbcUtil;
import com.tgb.util.SendMail;

@Controller
@RequestMapping("/userJson")
public class UserJsonController {

	@Autowired
	private UserService userService;
	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getAllUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAllUser(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		List<User> findAll = userService.findAll();
		return JSON.toJSONString(findAll).toString();
	}
	
	
	/**
	 * 代码生成
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/createCode", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String createCode(HttpServletRequest request,RedirectAttributes attr){
		String jdbcType = request.getParameter("jdbcType");
		String jdbcUrl = request.getParameter("jdbcUrl");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String table = request.getParameter("tableName");
		try {
			Connection connection = JdbcUtil.getConnection(jdbcType,jdbcUrl,user,password);
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			if(table!=null && !"".equals(table)){
				ResultSet rs = databaseMetaData.getColumns(null,"%", table,"%");
				//生成model文件
				GenerateUtil.generateModelFile(rs,table);
				//生成dao文件
				GenerateUtil.generateDaoFile(table);
				//生成service文件
				GenerateUtil.generateServiceFile(table);
				//生成serviceImpl文件
				GenerateUtil.generateServiceImplFile(table);
				//生成controller文件
				GenerateUtil.generateControllerFile(table);
				//生成mapper文件
				rs = databaseMetaData.getColumns(null,"%", table,"%");
				GenerateUtil.generateMapperFile(rs,table);
			}else{
				ResultSet resultSet = JdbcUtil.getTables(databaseMetaData,user);
				while (resultSet.next()) {
					String tableName = resultSet.getString("TABLE_NAME");
					ResultSet rs = databaseMetaData.getColumns(null,"%", tableName,"%");
					//生成model文件
					GenerateUtil.generateModelFile(rs,tableName);
					//生成dao文件
					GenerateUtil.generateDaoFile(tableName);
					//生成service文件
					GenerateUtil.generateServiceFile(tableName);
					//生成serviceImpl文件
					GenerateUtil.generateServiceImplFile(tableName);
					//生成controller文件
					GenerateUtil.generateControllerFile(tableName);
					//生成mapper文件
					rs = databaseMetaData.getColumns(null,"%", tableName,"%");
					GenerateUtil.generateMapperFile(rs,tableName);
				}
			}
		} catch (Exception e) {
			return e.toString();
		}
		return "success";
	}

}
