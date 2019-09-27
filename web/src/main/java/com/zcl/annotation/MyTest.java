package com.zcl.annotation;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * java-study .
 *
 * @description: .
 * @author: homolo .
 * @date: 19-4-17 .
 */
public class MyTest implements MyInterface {

	@MyAnnotation(hello = "Hello,Beijing", world = "Hello,world")
	public void output() {
		System.out.println("method output is running");
	}

	@Override
	public void skd() {
		System.out.println("11");
	}

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		throw new NumberFormatException();
	}
}
