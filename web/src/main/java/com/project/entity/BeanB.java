package com.project.entity;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-6 .
 */
@Service
public class BeanB {

	@PostConstruct
	private void init() {
		System.out.println("这是BeanB 的init 方法");
	}

	public BeanB() {
		System.out.println("这是Bean B的 构造方法");
	}

	void testB() {
		System.out.println("这是Bean B 的 testB 方法");
	}
}
