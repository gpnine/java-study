package com.example.demo.component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * chapter02 .
 *
 * @description: 自定义侦听器.
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@WebListener
public class MyListener implements ServletRequestListener {
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("MyListener>>>requestDestoryed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("MyListener>>>requestInitialized");
	}
}
