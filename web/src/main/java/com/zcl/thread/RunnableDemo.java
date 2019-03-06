package com.zcl.thread;

/**
 * RunnableDemo .
 *
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-21.
 */
public class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;

	public RunnableDemo(String threadName) {
		this.threadName = threadName;
		System.out.println("Createing " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try {
			Thread.sleep(50);
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread:" + threadName + "," + i);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread:" + threadName + "interputed");
		}
		System.out.println("Thread:" + threadName + "," + "exiting");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (this.t == null) {
			this.t = new Thread(this, this.threadName);
			this.t.start();
		}
	}
}
