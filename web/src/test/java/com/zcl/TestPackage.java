package com.zcl;

import com.zcl.study.Person;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-7.
 */
public class TestPackage {

	public static void main(String[] args) {
		Person person = new Person();
		person.setAge(22);
		person.setSex("1");
		System.out.println(person.getAge());
		System.out.println(person.getSex());
	}
}
