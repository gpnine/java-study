package com.example.springboot1.domain.s;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByName(String name);

	Person findByNameAndAge(String name, Integer age);

	@Query("from Person u where u.name=:name")
	Person findPerson(@Param("name") String name);
}
