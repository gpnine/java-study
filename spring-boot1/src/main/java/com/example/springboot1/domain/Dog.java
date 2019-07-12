package com.example.springboot1.domain;

import org.springframework.data.annotation.Id;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-12 .
 */
public class Dog {
	@Id
	private Long dogId;

	private String dogname;
	private Integer age;

	public Dog() {
	}

	public Dog(Long id, String dogname, Integer age) {
		this.dogId = id;
		this.dogname = dogname;
		this.age = age;
	}

	public Long getDogId() {
		return dogId;
	}

	public void setDogId(Long dogId) {
		this.dogId = dogId;
	}

	public String getDogname() {
		return dogname;
	}

	public void setDogname(String dogname) {
		this.dogname = dogname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
