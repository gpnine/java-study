package com.example.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring-boot2 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-16 .
 */
@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
