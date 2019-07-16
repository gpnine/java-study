package com.example.springboot1.controller;

import com.example.springboot1.expection.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	@ResponseBody
	public String hello(@RequestParam String name) {
		return "Hello "+name;
	}

	@RequestMapping("/json")
	public String json() throws MyException{
		throw new MyException("发生错误2");
	}
}
