package com.project.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * web .
 *
 * @description: 生成对象时完成某些初始化操作,
 * 而偏偏这些初始化操作又依赖于依赖注入，
 * 那么就无法在构造函数中实现。为此，
 * 可以使用@PostConstruct注解一个方法来完成初始化.
 * @author: Chenglin Zhu .
 * @date: 19-9-6 .
 */
@Service
public class BeanA {

	@Autowired
	private BeanB beanB;

	public BeanA() {
		System.out.println("这是Bean A 的构造方法");
	}


	@PostConstruct
	private void init() {
		System.out.println("这是BeanA的 init 方法");
		beanB.testB();
	}
}
