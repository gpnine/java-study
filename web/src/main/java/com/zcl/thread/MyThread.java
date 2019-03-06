package com.zcl.thread;

/**
 * MyThread .
 *
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-23.
 */
public class MyThread extends Thread {
	private static int num = 1;

	public MyThread() {
		num++;
	}

	@Override
	public void run() {
		System.out.println("主动创建的第" + num + "个进程");
	}

}
