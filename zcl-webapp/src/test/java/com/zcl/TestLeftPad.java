package com.zcl;

import org.apache.commons.lang3.StringUtils;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-9.
 */
public class TestLeftPad {
	public static void main(String[] args) {
		for (int i = 0; i <= 1000; i++) {
			System.out.println(StringUtils.leftPad(String.valueOf(i), 4, "0"));
		}
	}
}
