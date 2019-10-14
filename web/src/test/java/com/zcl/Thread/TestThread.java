package com.zcl.Thread;

import com.zcl.thread.MyFirstThread;
import com.zcl.thread.MyRunnable;
import com.zcl.thread.MyThread;
import com.zcl.thread.RunnableDemo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
		System.out.println("主线程ID:" + Thread.currentThread().getId());
		MyFirstThread thread1 = new MyFirstThread("thread1");
		thread1.start();
		MyFirstThread thread2 = new MyFirstThread("thread2");
		thread2.run();
	}

	@Test
	public void testThread3() {
		System.out.println("主线程ID:" + Thread.currentThread().getId());
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
	}

	@Test
	public void testSocket() {
		int port = 4343; //端口号
		// Socket 服务器端（简单的发送信息）
		Thread sThread = new Thread(() -> {
			try {
				ServerSocket serverSocket = new ServerSocket(port);
				while (true) {
					// 等待连接
					Socket socket = serverSocket.accept();
					Thread sHandlerThread = new Thread(() -> {
						try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
							printWriter.println("hello world！");
							printWriter.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
					sHandlerThread.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		sThread.start();
		// Socket 客户端（接收信息并打印）
		try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			bufferedReader.lines().forEach(s -> System.out.println("客户端：" + s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNio() {
		int port = 4343; //端口号
		// NIO 多路复用
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 4,
				60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		threadPool.execute(() -> {
			try (Selector selector = Selector.open(); ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
				serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
				serverSocketChannel.configureBlocking(false);
				serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
				while (true) {
					selector.select(); // 阻塞等待就绪的Channel
					Set<SelectionKey> selectionKeys = selector.selectedKeys();
					Iterator<SelectionKey> iterator = selectionKeys.iterator();
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						try (SocketChannel channel = ((ServerSocketChannel) key.channel()).accept()) {
							channel.write(Charset.defaultCharset().encode("你好，世界"));
						}
						iterator.remove();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

// Socket 客户端（接收信息并打印）
		try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			bufferedReader.lines().forEach(s -> System.out.println("NIO 客户端：" + s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
