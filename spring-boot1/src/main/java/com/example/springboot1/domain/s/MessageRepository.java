package com.example.springboot1.domain.s;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

}
