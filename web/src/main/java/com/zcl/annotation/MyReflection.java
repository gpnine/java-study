package com.zcl.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * java-study .
 *
 * @description: .
 * @author: homolo .
 * @date: 19-4-17 .
 */
public class MyReflection {
	public static void main(String[] args) throws NoSuchMethodException {
//		Class<MyTest> myTestClass = MyTest.class;
		Method method = MyTest.class.getMethod("output");
		if (method.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
			System.out.println(annotation.hello());
			System.out.println(annotation.world());
		}
		System.out.println("-------------------------");
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType().getName());
		}
	}
}
