package com.example.springboot2.controller;

import com.example.springboot2.domain.User;
import com.example.springboot2.domain.UserMapper;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * spring-boot2 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-12 .
 */
@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/findAge")
	public int findAge() {
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		return u.getAge();
	}

	@RequestMapping("/addUser")
	public int addUser() {
		Map<String, Object> map = Maps.newHashMap();
		map.put("name", "CCC");
		map.put("age", 40);
		return userMapper.insertByMap(map);
	}

	@RequestMapping("/findUser")
	public int findUser() {
		User user = new User();
		user.setName("zcl");
		user.setAge(25);
		return userMapper.insertByUser(user);
	}

	@RequestMapping("/updateUser")
	public void updateUser() {
		User user = userMapper.findByName("zcl");
		user.setAge(26);
		userMapper.update(user);
	}

	@RequestMapping("/delete")
	public void delete(Long id) {
		userMapper.delete(id);
	}

	@RequestMapping("/findAll")
	public List<User> findAll() {
		return userMapper.findAll();
	}
}
