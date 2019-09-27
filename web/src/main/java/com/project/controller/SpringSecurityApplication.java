package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-26 .
 */
@Controller
public class SpringSecurityApplication {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(HttpServletRequest request) {
		String name = request.getParameter("username");
		return "hello" + name;
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(name + "-" + password);
		return "index";
	}
}
