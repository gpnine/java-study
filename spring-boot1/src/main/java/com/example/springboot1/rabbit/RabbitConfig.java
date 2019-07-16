package com.example.springboot1.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-16 .
 */
@Configuration
public class RabbitConfig {
	@Bean
	public Queue helloQueue() {
		return new Queue("hello");
	}
}
