package com.example.spring_kafka_v1.producer;

import com.example.spring_kafka_v1.dao.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, Message> objectKafkaTemplate;

    private final KafkaTemplate<String, String> stringKafkaTemplate;


    @Autowired
    public KafkaProducer(
            @Qualifier("stringKafkaTemplate") KafkaTemplate<String, String> stringKafkaTemplate,
            @Qualifier("objectKafkaTemplate") KafkaTemplate<String, Message> objectKafkaTemplate) {
        this.stringKafkaTemplate = stringKafkaTemplate;
        this.objectKafkaTemplate = objectKafkaTemplate;
    }

    public void sendObjectMessage(String topic, Message message) {
        objectKafkaTemplate.send(topic, message);
    }

    public void sendStringMessage(String topic, String message) {
        stringKafkaTemplate.send(topic, message);
    }
}
