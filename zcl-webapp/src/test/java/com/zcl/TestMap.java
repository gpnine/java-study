package com.zcl;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-21.
 */
public class TestMap {

	@Test
	public void testMap() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		map.put("5", 5);
		System.out.println(map.toString());
	}
}