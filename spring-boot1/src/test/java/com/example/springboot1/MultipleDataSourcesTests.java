package com.example.springboot1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class MultipleDataSourcesTests {
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate2;

	@Before
	public void setUp() {
		jdbcTemplate1.update("delete from person");
		jdbcTemplate2.update("delete from person");
	}

	@Test
	public void test() {
		jdbcTemplate1.update("insert into person(id,name,age) values(?,?,?)", 1, "aaa", 20);
		jdbcTemplate1.update("insert into person(id,name,age) values(?,?,?)", 2, "bbb", 30);

		jdbcTemplate2.update("insert into person(id,name,age) values(?,?,?)", 1, "aaa", 20);

		Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from person", String.class));
		Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from person", String.class));
	}
}
