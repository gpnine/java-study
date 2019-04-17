package com.zcl.annotation;

/**
 * java-study .
 *
 * @description: .
 * @author: homolo .
 * @date: 19-4-17 .
 */
public class MyTest {

	@MyAnnotation(hello = "Hello,Beijing", world = "Hello,world")
	public void output() {
		System.out.println("method output is running");
	}
}
