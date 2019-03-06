package com.zcl;

import com.zcl.inner.Son;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-11.
 */
public class TestInner {
	public static void main(String[] args) {
		Son son = new Son();
		System.out.println(son.getStrong());
		System.out.println(son.getKind());
	}
}
