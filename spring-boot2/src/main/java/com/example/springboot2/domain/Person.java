package com.example.springboot2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * spring-boot2 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-15 .
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 5)
	private String name;

	@Column
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
