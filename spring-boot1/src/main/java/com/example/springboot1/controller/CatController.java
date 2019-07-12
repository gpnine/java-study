package com.example.springboot1.controller;

import com.example.springboot1.domain.Cat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-12 .
 */
@RestController
public class CatController {
	@PostMapping("/cat")
	public Cat cat(@RequestBody Cat cat) {
		return cat;
	}
}
