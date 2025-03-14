package com.yuri.worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class BackendWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendWorkerApplication.class, args);
	}

}
