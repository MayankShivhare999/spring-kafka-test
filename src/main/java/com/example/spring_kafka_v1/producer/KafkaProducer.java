package com.example.spring_kafka_v1.producer;

import com.example.spring_kafka_v1.dao.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    public void sendMessage(String topic, String message) {
//        kafkaTemplate.send(topic, message);
//    }

    public void sendMessage(String topic, Message message) {
        kafkaTemplate.send(topic, message);
    }
}
