package com.example.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
@Controller
public class PageController {

	@RequestMapping("/")
	public String index(ModelMap map){
		map.addAttribute("host","It is a joke");
		return "index";
	}
}
