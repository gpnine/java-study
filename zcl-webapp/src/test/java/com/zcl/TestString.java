package com.zcl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-11.
 */
public class TestString {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestString.class);

	public static void main(String[] args) {
		String a = "asdfasdf,";//[)
		String b= "asdasdf";
		LOGGER.info("a:{}",a.regionMatches(1,b,1,2));
		System.out.println(a.startsWith("a",0));
	}
}
