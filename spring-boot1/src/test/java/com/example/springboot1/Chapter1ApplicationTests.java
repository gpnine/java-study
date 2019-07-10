package com.example.springboot1;

import com.example.springboot1.controller.HelloController;
import com.example.springboot1.entity.BlogProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-9 .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class Chapter1ApplicationTests {

	private static final Log log = LogFactory.getLog(Chapter1ApplicationTests.class);

	private MockMvc mvc;
	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void getName(){
		Assert.assertEquals("朱成琳", blogProperties.getName());
		Assert.assertEquals("学习Spring", blogProperties.getTitle());
		Assert.assertEquals("朱成琳努力《学习Spring》", blogProperties.getDesc());

		log.info("随机数测试输出：");
		log.info("随机字符串 : " + blogProperties.getValue());
		log.info("随机int : " + blogProperties.getNumber());
		log.info("随机long : " + blogProperties.getBignumber());
		log.info("随机10以下 : " + blogProperties.getTest1());
		log.info("随机10-20 : " + blogProperties.getTest2());
	}

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World!!!")));
	}

}
