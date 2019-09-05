package com.project.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.SpringConfiguration;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-8-30 .
 */
public class MainApp {
	public static void main(String[] args) {
		// 获取配置文件的方法
		ApplicationContext context =
				new ClassPathXmlApplicationContext("Beans.xml");

		Student student = (Student) context.getBean("student");

		student.getAge();

		// JavaConfig配置的方法
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext(SpringConfiguration.class);

		Student student1 = (Student) applicationContext.getBean("student");

		student1.getAge();
	}
}
