package com.example.springboot1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-11 .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() {
		stringRedisTemplate.opsForValue().set("aaa","111");
		Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
	}
}
