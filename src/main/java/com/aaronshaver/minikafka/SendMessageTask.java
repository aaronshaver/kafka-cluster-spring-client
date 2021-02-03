package com.aaronshaver.minikafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

@Component
public class SendMessageTask {
    private final Logger logger = LoggerFactory.getLogger(SendMessageTask.class);

    private final Producer producer;

    public SendMessageTask(Producer producer) {
        this.producer = producer;
    }

    // run every 3,000 ms
    @Scheduled(fixedRateString = "3000")
    public void send() throws ExecutionException, InterruptedException {
        logger.debug("\n\ntest debug message\n\n");

        ListenableFuture<SendResult<String, String>> listenableFuture = this.producer.sendMessage("INPUT_DATA", "IN_KEY", LocalDate.now().toString());

        SendResult<String, String> result = listenableFuture.get();
        logger.info(String.format("\nProduced:\ntopic: %s\noffset: %d\npartition: %d\nvalue size: %d\n", result.getRecordMetadata().topic(), result.getRecordMetadata().offset(), result.getRecordMetadata().partition(), result.getRecordMetadata().serializedValueSize()));
        if (logger.isDebugEnabled()) {
            logger.info("debug is enabled");
        }
        else {
            logger.info("debug is not enabled");
        }
        logger.debug("\n\ntest debug message\n\n");
    }
}

