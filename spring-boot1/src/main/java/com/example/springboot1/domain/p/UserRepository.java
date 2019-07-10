package com.example.springboot1.domain.p;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
