package com.zcl.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程.
 *
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-23.
 */
public class MyFirstThread extends Thread {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyFirstThread.class);

	private String name;

	public MyFirstThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("name:" + name + " 子线程ID:" + Thread.currentThread().getId());
	}
}
