package com.kafka.restfull.event;

import com.kafka.restfull.entities.Message;
import com.kafka.restfull.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.Instant;

public class MessageProducer {

    private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);
    private static final String TOPIC = "message";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(final String message){
        kafkaTemplate.send(TOPIC, message);
        messageRepository.save(new Message(message, Instant.now()));
        log.info("#### -> Producing message -> {}", message);
    }
}
