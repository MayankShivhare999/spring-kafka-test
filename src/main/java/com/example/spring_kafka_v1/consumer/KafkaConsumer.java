package com.example.spring_kafka_v1.consumer;

import com.example.spring_kafka_v1.dao.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${kafka.topic.object}", groupId = "${kafka.group.object}", containerFactory = "objectKafkaListenerContainerFactory")
    public void listenObject(Message message) {
        logger.info("Received Object: {} {}", message.getId(), message.getContent());
    }

    @KafkaListener(topics = "${kafka.topic.string}", groupId = "${kafka.group.string}", containerFactory = "stringKafkaListenerContainerFactory")
    public void listenString(String message) {
        logger.info("Received String: {}", message);
    }
}