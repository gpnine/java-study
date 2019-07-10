package com.example.springboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public void create(String name, Integer age) {
		jdbcTemplate.update("insert into user(name,age) values(?,?)", name, age);
	}

	@Override
	public void deleteByName(String name) {
		jdbcTemplate.update("delete from user where name = ?", name);
	}

	@Override
	public Integer getAllUsers() {
		return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		jdbcTemplate.update("delete from user");
	}
}
