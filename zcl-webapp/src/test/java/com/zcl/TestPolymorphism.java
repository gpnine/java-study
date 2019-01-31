package com.zcl;

import com.zcl.polymorphism.JNC;
import com.zcl.polymorphism.Wine;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-7.
 */
public class TestPolymorphism {
	public static void main(String[] args) {
		Wine wine = new JNC();
		wine.fun1();
		wine.fun2();
	}
}
