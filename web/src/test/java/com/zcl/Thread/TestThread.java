package com.zcl.Thread;

import com.zcl.thread.MyFirstThread;
import com.zcl.thread.MyRunnable;
import com.zcl.thread.MyThread;
import com.zcl.thread.RunnableDemo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-21.
 */
public class TestThread {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestThread.class);

	@Test
	public void testRunable2() {
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();
		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start();
	}

	@Test
	public void testRunable() {
		Runable1 runable1 = new Runable1();
		// public Thread(Runnable
		// paramRunnable)构造方法,这里的paramRunnable为父类引用指向自类对象,用到了多态的知识
		Thread thread = new Thread(runable1);
		// Thread中最重要的方法。通知CPU新建了一个线程,这样CPU的时间片才会轮播到这个线程
		thread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println(" mainClass:" + i);
		}
	}

	static class Runable1 implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println(" subclass:" + i);
			}
		}
	}

	@Test
	public void testThread() {
		MyThread thread = new MyThread();
		thread.start();
	}

	@Test
	public void testThread2() {
		System.out.println("主线程ID:"+Thread.currentThread().getId());
		MyFirstThread thread1 = new MyFirstThread("thread1");
		thread1.start();
		MyFirstThread thread2 = new MyFirstThread("thread2");
		thread2.run();
	}

	@Test
	public void testThread3(){
		System.out.println("主线程ID:"+Thread.currentThread().getId());
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
	}
}
