package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * chapter02 Aop切面切入service包下所有类的所有方法.
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@Aspect
@Component
public class LogAspect {
	@Pointcut("execution(* com.example.demo.service.*.*(..))")
	public void pcl() {
	}

	@Before(value = "pcl()")
	public void before(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法开始执行...");
	}

	@After(value = "pcl()")
	public void after(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法执行结束...");
	}

	@AfterReturning(value = "pcl()", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法返回值为：" + result);
	}

	@AfterThrowing(value = "pcl()", throwing = "e")
	public void afterThrowing(JoinPoint jp, Exception e) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法抛异常了，异常是：" + e.getMessage());
	}

	@Around("pcl()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		return pjp.proceed();
	}
}
