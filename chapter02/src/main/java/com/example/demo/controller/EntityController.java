package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@RestController
public class EntityController {

	@GetMapping("/hello")
	public void hello(Model model) {
		Map<String, Object> map = model.asMap();
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = map.get(key);
			System.out.println(key + ">>>>" + value);
		}
	}
}
