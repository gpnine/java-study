package com.project.entity;

import org.apache.commons.lang3.StringUtils;

/**
 * JAVAWeb-Advanced .
 *
 * @description: .
 * @author: ChengLin Zhu .
 * @date: 19-1-30 .
 */
public class User {
	private Integer id;

	private String userName;

	private String password;

	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", age=" + age + "]";
	}

//	@Override
//	public boolean equals(Object obj) {
//		return userName.equals(((User) obj).getUserName());//这里以name为判定标准。
//	}


	@Override
	public int hashCode() {
		System.out.println("判断 hashCode");
		return 1; // 返回1，说明所有新建的对象的哈希值都为1，也就是相同
	}

	@Override
	public boolean equals(Object o) {
		System.out.println("判断 equals");
		return false; // 返回false
	}
}
