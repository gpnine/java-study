package com.example.springboot2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring-boot2 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-15 .
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
