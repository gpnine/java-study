package com.example.springboot1;

import com.example.springboot1.domain.s.Person;
import com.example.springboot1.domain.s.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class PersonApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void test() {

		// 创建10条记录
		personRepository.save(new Person("AAA", 10));
		personRepository.save(new Person("BBB", 20));
		personRepository.save(new Person("CCC", 30));
		personRepository.save(new Person("DDD", 40));
		personRepository.save(new Person("EEE", 50));
		personRepository.save(new Person("FFF", 60));
		personRepository.save(new Person("GGG", 70));
		personRepository.save(new Person("HHH", 80));
		personRepository.save(new Person("III", 90));
		personRepository.save(new Person("JJJ", 100));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, personRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的Person
		Assert.assertEquals(60, personRepository.findByName("FFF").getAge().longValue());

		// 测试findPerson, 查询姓名为FFF的Person
		Assert.assertEquals(60, personRepository.findPerson("FFF").getAge().longValue());

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的Person
		Assert.assertEquals("FFF", personRepository.findByNameAndAge("FFF", 60).getName());

		// 测试删除姓名为AAA的Person
		personRepository.delete(personRepository.findByName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, personRepository.findAll().size());

	}
}
