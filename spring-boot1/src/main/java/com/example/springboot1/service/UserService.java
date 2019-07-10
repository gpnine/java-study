package com.example.springboot1.service;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
public interface UserService {

	/**
	 * 新增一个用户.
	 *
	 * @param name 姓名.
	 * @param age  　年龄.
	 */
	void create(String name, Integer age);

	/**
	 * 根据name删除一个用户.
	 *
	 * @param name 姓名.
	 */
	void deleteByName(String name);

	/**
	 * 获取用户总量.
	 */
	Integer getAllUsers();

	/**
	 * 删除用户总量.
	 */
	void deleteAllUsers();

}
