package com.example.springboot1.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-16 .
 */
@Component
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() {
		String context = "hello!" + new Date();
		System.out.println("Sender:" + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}
}
