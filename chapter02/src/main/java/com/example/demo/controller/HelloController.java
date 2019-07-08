package com.example.demo.controller;

import com.example.demo.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@RestController
public class HelloController {
	@Autowired
	Hello hello;

	@GetMapping("/hi")
	public String hi() {
		return hello.sayHello("江南一点雨");
	}

	@GetMapping("/test")
	public String hello() {
		int i = 1 / 0;
		return "test";
	}
}
