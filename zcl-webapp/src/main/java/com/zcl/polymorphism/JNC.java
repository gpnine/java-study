package com.zcl.polymorphism;

/**
 * JNC.
 *
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-7.
 */
public class JNC extends Wine {
	public void fun1(String a) {
		System.out.println("JNC的fun1");
		fun2();
	}

	public void fun2() {
		System.out.println("JNC的fun2");
	}
}
