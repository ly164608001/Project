package com.tgb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgb.service.ITUserService;

/**
 * TUser鎺у埗灞�
 * 
 * @author 
 * @date  2017-05-27
 */
@Controller
@RequestMapping("/tUser")
public class TUserController {

	@Autowired
	private ITUserService tUserService;

	@RequestMapping("/showTUser.do")
	public String showTUser(HttpServletRequest request,HttpServletResponse response) {
		return "/tUser/tUserIndex";
	}

	@RequestMapping("/updateTUser.do")
	public String updateTUser(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().setAttribute("id", request.getParameter("id"));
		return "/tUser/tUserIndex";
	}

}
