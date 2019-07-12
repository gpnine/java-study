package com.example.springboot1;

import com.example.springboot1.domain.Dog;
import com.example.springboot1.domain.DogRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-12 .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DogTests {

	@Autowired
	private DogRepository dogRepository;

	@Before
	public void setUp() {
		dogRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {
		dogRepository.save(new Dog(1L, "didi", 20));
		dogRepository.save(new Dog(2L, "mama", 40));
		dogRepository.save(new Dog(3L, "kaka", 50));
		List<Dog> dogs = dogRepository.findAll();
		Assert.assertEquals(3, dogs.size());
		dogRepository.deleteById(1L);
		Assert.assertEquals(2, dogRepository.findAll().size());
		Dog dog = dogRepository.findByDogname("mama");
		dogRepository.delete(dog);
		Assert.assertEquals(1, dogRepository.findAll().size());
	}
}
