package com.zcl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * java-study .
 *
 * @description: 自定义注解.
 * @author: Chenglin Zhu .
 * @date: 19-4-17 .
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String hello() default "hello";

	String world();
}
