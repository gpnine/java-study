//package com.example.springboot1;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.statemachine.annotation.OnTransition;
//import org.springframework.statemachine.annotation.WithStateMachine;
//
///**
// * spring-boot1 .
// *
// * @description: .
// * @author: Chenglin Zhu .
// * @date: 19-7-16 .
// */
///**
// * 该配置实现了StateMachineConfig类中定义的状态机监听器实现。
// */
//@WithStateMachine
//public class EventConfig {
//	private Logger logger = LoggerFactory.getLogger(getClass());
//
//	@OnTransition(target = "UNPAID")
//	public void create() {
//		logger.info("订单创建，待支付");
//	}
//
//	@OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
//	public void pay() {
//		logger.info("用户完成支付，待收货");
//	}
//
//	@OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
//	public void receive() {
//		logger.info("用户已收货，订单完成");
//	}
//
//}
