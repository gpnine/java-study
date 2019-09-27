package com.zcl;

/**
 * web .
 *
 * @description: 镜头.
 * @author: Chenglin Zhu .
 * @date: 19-9-25 .
 */
public class VariantTest {
	public static int staticVar = 0;

	public int instanceVar = 0;

	public VariantTest() {
		staticVar++;
		instanceVar++;
		System.out.println(staticVar + instanceVar);
	}

	public static void main(String arg[]) {
		VariantTest variantTest = new VariantTest();
		variantTest.kite();
	}

	public void kite() {
		System.out.println("1");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.max(1, 2));
		System.out.println(Integer.decode("-2323"));
		System.out.println(Integer.toUnsignedString(23));
	}
}
