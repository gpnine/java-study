package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@RestController
@RequestMapping("/web")
public class LoginController {
	@PostMapping("/login")
	public void login(HttpServletRequest req) {
		System.out.println(req.getParameter("userName"));
		System.out.println(req.getParameter("password"));
	}
}
