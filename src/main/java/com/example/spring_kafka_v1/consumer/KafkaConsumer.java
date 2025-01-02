package com.example.spring_kafka_v1.consumer;

import com.example.spring_kafka_v1.dao.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(Message message) {
        System.out.println("Received Message: " + message.getId()+" "+message.getContent());
    }
}

