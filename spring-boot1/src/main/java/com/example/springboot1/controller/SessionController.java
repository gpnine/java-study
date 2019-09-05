package com.example.springboot1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-17 .
 */
@RestController
public class SessionController {
	@Value("${server.port}")
	String port;

	// Spring Session透明替换HttpSession容器到redis中
	@PostMapping("/save")
	public String saveName(String name, HttpSession session) {
		session.setAttribute("name", name);
		return port;
	}

	@GetMapping("/get")
	public String getName(HttpSession session) {
		return port + ":" + session.getAttribute("name").toString();
	}
}
