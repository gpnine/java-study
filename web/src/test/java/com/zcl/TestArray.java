package com.zcl;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-14.
 */
public class TestArray {
	public static void main(String[] args) {
		int[] array = new int[10];
		int array2[] = new int[10];
		System.out.println(array.getClass().getSuperclass());
		System.out.println(array.getClass().getName());
		System.out.println(array.getClass());
		System.out.println(array.getClass().getDeclaredMethods().length);
		List<String> list = Lists.newArrayList();
		System.out.println(list.get(0));
	}

}
