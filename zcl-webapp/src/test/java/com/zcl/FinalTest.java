package com.zcl;

import com.zcl.study.Person;

import java.util.Random;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-11.
 */
public class FinalTest {
	private final String final_01 = "chenssy";    //编译期常量，必须要进行初始化，且不可更改
	private final String final_02;                //构造器常量，在实例化一个对象时被初始化

	private static Random random = new Random();
	private final int final_03 = random.nextInt(50);    //使用随机数来进行初始化,在运行期才能知道其值

	//引用
	public final Person final_04 = new Person("chen_ssy");    //final指向引用数据类型

	FinalTest(String final_02){
		this.final_02 = final_02;
	}

	public String toString(){
		return "final_01 = " + final_01 +"   final_02 = " + final_02 + "   final_03 = " + final_03 +
				"   final_04 = " + final_04.getName();
	}

	public static void main(String[] args) {
		System.out.println("------------第一次创建对象------------");
		FinalTest final1 = new FinalTest("cm");
		System.out.println(final1);
		System.out.println("------------第二次创建对象------------");
		FinalTest final2 = new FinalTest("zj");
		System.out.println(final2);
		System.out.println("------------修改引用对象--------------");
		final2.final_04.setName("chenssy");
		System.out.println(final2);
	}
}
