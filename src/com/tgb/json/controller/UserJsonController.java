package com.tgb.json.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mchange.v1.util.SetUtils;
import com.tgb.model.User;
import com.tgb.service.UserService;
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
}
