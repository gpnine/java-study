package com.example.springboot1.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-16 .
 */
@Component
@RabbitListener(queues = "hello")
public class Reciver {

	@RabbitHandler
	public void process(String hello) {
		System.out.println("Reciver:" + hello);
	}
}
