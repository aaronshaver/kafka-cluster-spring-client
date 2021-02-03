package com.aaronshaver.minikafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "aaronshaver.kafka.consumer-enabled", havingValue = "true")
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "INPUT_DATA", groupId = "fooGroup")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group fooGroup: " + message);
    }

}
