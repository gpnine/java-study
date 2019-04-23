package com.example.demo.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@Component
@Order(2)
public class MyCommandLineRunner2 implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner2>>>" + Arrays.toString(args));
	}
}
