package com.example.springboot1;

import com.example.springboot1.domain.p.User;
import com.example.springboot1.domain.p.UserRepository;
import com.example.springboot1.domain.s.Message;
import com.example.springboot1.domain.s.MessageRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JpaMultipleDataSourcesTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private CacheManager cacheManager;

	@Test
	public void test() {
		userRepository.save(new User("aaa", 10));
		userRepository.save(new User("bbb", 20));
		userRepository.save(new User("ccc", 30));
		userRepository.save(new User("ddd", 40));
		userRepository.save(new User("eee", 50));

		Assert.assertEquals(5, userRepository.findAll().size());

		messageRepository.save(new Message("o1", "aaaaaaaaaa"));
		messageRepository.save(new Message("o2", "bbbbbbbbbb"));
		messageRepository.save(new Message("o3", "cccccccccc"));

		Assert.assertEquals(3, messageRepository.findAll().size());
	}

	@Before
	public void before() {
		userRepository.save(new User("AAA", 11));
	}

	@Test
	public void testCache() {
		User u1 = userRepository.findByName("AAA");
		System.out.println("第一次查询：" + u1.getAge());
		User u2 = userRepository.findByName("AAA");
		System.out.println("第二次查询：" + u2.getAge());

		u1.setAge(20);
		userRepository.save(u1);
		User u3 = userRepository.findByName("AAA");
		System.out.println("第三次查询：" + u3.getAge());
	}
}
