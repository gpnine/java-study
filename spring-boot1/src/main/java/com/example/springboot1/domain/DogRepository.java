package com.example.springboot1.domain;


import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-12 .
 */
public interface DogRepository extends MongoRepository<Dog, Long> {

	Dog findByDogname(String dogname);

}
