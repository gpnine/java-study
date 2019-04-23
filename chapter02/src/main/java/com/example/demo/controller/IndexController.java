package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@RestController
public class IndexController {
	@RequestMapping("/index1")
	public String hello() {
		return "index";
	}
}
