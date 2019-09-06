package com.project.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-8-30 .
 */
public class Student {
	private Integer age;
	private String name;

	public Student(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

	public Student() {
		super();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Bean
	public Integer getAge() {
		System.out.println("Age : " + age);
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		System.out.println("Name : " + name);
		return name;
	}

	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}
}


