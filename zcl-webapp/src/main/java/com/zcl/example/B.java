package com.zcl.example;

/** 子类.
 * @description: B子类.
 * @author: ChengLin Zhu.
 * @date: 19-1-7.
 */
public class B extends A {
	/** 子类重载父类方法.
	 * 父类中不存在该方法，向上转型后，父类是不能引用该方法的
	 * @param obj B对象
	 * @return  B
	 */
	public String show(B obj) {
		return ("B and B");
	}

	/** 子类重写父类方法.
	 * 指向子类的父类引用方法调用时，必定是调用该方法
	 * @param obj A对象
	 * @return  A
	 */
	public String show(A obj) {
		return ("B and A");
	}
}
