package com.zcl.thread;

/**
 * MyRunable .
 *
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-23.
 */
public class MyRunnable implements Runnable {


	public MyRunnable() {
	}

	@Override
	public void run() {
		System.out.println("子线程ID=" + Thread.currentThread().getId());
	}
}
