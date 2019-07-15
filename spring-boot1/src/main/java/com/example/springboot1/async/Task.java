package com.example.springboot1.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-15 .
 */
@Slf4j
@Component
public class Task {
	private static Random random = new Random();
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Async("taskExecutor")
	public Future<String> doTaskOne() {
		log.info("开始做任务一");
		long start = System.currentTimeMillis();
		log.info(stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		log.info("完成任务一，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务一完成");
	}

	@Async("taskExecutor")
	public Future<String> doTaskTwo() {
		log.info("开始做任务二");
		long start = System.currentTimeMillis();
		log.info(stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		log.info("完成任务二，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务二完成");
	}

	@Async("taskExecutor")
	public Future<String> doTaskThree() {
		log.info("开始做任务三");
		long start = System.currentTimeMillis();
		log.info(stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		log.info("完成任务三，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务三完成");
	}

	@Async("taskExecutor")
	public Future<String> run() throws Exception {
		long sleep = random.nextInt(10000);
		log.info("开始任务，需耗时：" + sleep + "毫秒");
		Thread.sleep(sleep);
		log.info("完成任务");
		return new AsyncResult<>("test");
	}
}
