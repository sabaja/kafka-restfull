package com.kafka.restfull.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class MessageConsumer {
    private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);
    private static final String TOPIC = "message";

    @KafkaListener(topics = TOPIC, groupId = "groupId")
    public void getMessage(String message){
        log.info("#### -> Consumed message -> {}", message);
    }
}
