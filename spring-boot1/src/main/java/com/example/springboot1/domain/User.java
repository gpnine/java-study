package com.example.springboot1.domain;


import java.io.Serializable;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-11 .
 */
public class User implements Serializable {

	private static final long serialVersionUID = -1L;
	private String username;
	private Integer age;

	public User(String username, Integer age) {
		this.username = username;
		this.age = age;
	}

	public User() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
