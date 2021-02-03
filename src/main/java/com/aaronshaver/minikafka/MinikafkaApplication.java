package com.aaronshaver.minikafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MinikafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinikafkaApplication.class, args);
	}

}
