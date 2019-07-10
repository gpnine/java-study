package com.example.springboot1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-9 .
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String index() {
		return "Hello World!!!";
	}
}
