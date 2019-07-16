package com.example.springboot1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-16 .
 */
@RestController
public class LogController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String testLogLevel(){
		logger.debug("Logger level : DEBUG");
		logger.info("Logger level : INFO");
		logger.error("Logger level : ERROR");
		return "";
	}
}
