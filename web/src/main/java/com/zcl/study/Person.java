package com.zcl.study;

/**
 * Person .
 *
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-7.
 */
public class Person {
	private String name;
	private String sex;
	private String age;

	public Person() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		if ("0".equals(this.sex)) {
			this.sex = "女";
		} else if ("1".equals(this.sex)) {
			this.sex = "男";
		} else {
			this.sex = "人妖???";
		}
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if (age > 120) {
			System.out.println("Error");
		} else {
			this.age = String.valueOf(age);
		}
	}

	public Person(String name) {
		this.name = name;
	}

}
