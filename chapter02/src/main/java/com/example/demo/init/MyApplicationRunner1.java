package com.example.demo.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@Component
@Order(2)
public class MyApplicationRunner1 implements ApplicationRunner {
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> nonOptionArgs = args.getNonOptionArgs();
		System.out.println("1-nonOptionArgs>>>" + nonOptionArgs);
		Set<String> optionNames = args.getOptionNames();
		for (String optionName : optionNames) {
			System.out.println("1-key:" + optionName + ";value:" + args.getOptionValues(optionName));
		}
	}
}
