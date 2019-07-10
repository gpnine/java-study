package com.example.springboot1;

import com.example.springboot1.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class UsersApplicationTests {

	@Autowired
	private UserService userService;

	@Before
	public void setUp() {
		//　清空表
		userService.deleteAllUsers();
	}

	@Test
	public void test() {
		userService.create("a", 1);
		userService.create("b", 2);
		userService.create("c", 3);
		userService.create("d", 4);
		userService.create("e", 5);

		Assert.assertEquals(5, userService.getAllUsers().intValue());

		userService.deleteByName("a");
		userService.deleteByName("e");

		Assert.assertEquals(3, userService.getAllUsers().intValue());

	}

}
