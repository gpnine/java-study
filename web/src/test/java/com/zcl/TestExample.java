package com.zcl;

import com.zcl.example.A;
import com.zcl.example.B;
import com.zcl.example.C;
import com.zcl.example.D;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-7.
 */
public class TestExample {

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println(a1.show(b));
		System.out.println(a1.show(a1));
		System.out.println(a1.show(c));
		System.out.println(a1.show(d));
		System.out.println(a2.show(b));
		System.out.println(a2.show(c));
		System.out.println(a2.show(d));
		System.out.println(b.show(b));
		System.out.println(b.show(c));
		System.out.println(b.show(d));
	}
}
