package com.example.springboot2;

import com.example.springboot2.domain.Person;
import com.example.springboot2.domain.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalApplicationTests {


	@Autowired
	private PersonRepository personRepository;

	@Test
	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED) // isolation隔离级别，propagation传播行为
	// 发生异常的时候被回退
	public void test() {
		personRepository.save(new Person("aaa", 1));
		personRepository.save(new Person("bbb", 2));
		personRepository.save(new Person("ccc", 3));
		personRepository.save(new Person("ddd", 4));
		personRepository.save(new Person("eeeeee", 5));
		personRepository.save(new Person("fff", 6));
		personRepository.save(new Person("ggg", 7));
		personRepository.save(new Person("hhh", 8));
	}
}
