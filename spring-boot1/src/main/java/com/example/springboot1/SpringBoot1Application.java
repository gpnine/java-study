package com.example.springboot1;

import com.example.springboot1.springenum.Events;
import com.example.springboot1.springenum.States;
import com.spring4all.mongodb.EnableMongoPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.statemachine.StateMachine;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableMongoPlus
@EnableScheduling
@EnableAsync
@EnableCaching
@EnableRedisHttpSession
@SpringBootApplication
public class SpringBoot1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... args) throws Exception {
		stateMachine.start();
		stateMachine.sendEvent(Events.PAY);
		stateMachine.sendEvent(Events.RECEIVE);
	}

	@EnableAsync
	@Configuration
	class TaskPoolConfig {
		@Bean("taskExecutor")
		public Executor taskExecutor() {
			ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			executor.setCorePoolSize(10);
			executor.setMaxPoolSize(20);
			executor.setQueueCapacity(200);
			executor.setKeepAliveSeconds(60);
			executor.setThreadNamePrefix("taskExecutor-");
			executor.setWaitForTasksToCompleteOnShutdown(true);
			executor.setAwaitTerminationSeconds(60);
			executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
			return executor;
		}
	}
}
