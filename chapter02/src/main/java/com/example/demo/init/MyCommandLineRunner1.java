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
@Order(1)
public class MyCommandLineRunner1 implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner1>>>" + Arrays.toString(args));
	}
}
