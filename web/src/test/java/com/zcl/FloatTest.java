package com.zcl;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-11.
 */
public class FloatTest {
	public static void main(String[] args) {
		float floatNumberA =  1.0F;
		float floatNumberB = 0;
		for (int addCount = 0; addCount < 10; addCount++) {
			floatNumberB += 0.1;
		}
		if (floatNumberB == floatNumberA) {
			System.out.println("equals");
		} else {
			System.out.println("unequals");
		}
	}
}