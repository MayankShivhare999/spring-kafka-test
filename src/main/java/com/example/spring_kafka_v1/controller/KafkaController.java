package com.example.spring_kafka_v1.controller;

import com.example.spring_kafka_v1.dao.Message;
import com.example.spring_kafka_v1.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/kafka-send")
public class KafkaController {

    @Value("${kafka.topic.object}")
    private String OBJECT_TOPIC;

    @Value("${kafka.topic.string}")
    private String STRING_TOPIC;

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/object")
    public String sendMessage(@RequestParam String message) {
        Message messageObj = new Message();
        messageObj.setId(UUID.randomUUID());
        messageObj.setContent(message);
        kafkaProducer.sendObjectMessage(OBJECT_TOPIC, messageObj);
        return "Object sent!";
    }

    @GetMapping("/string")
    public String sendMessageString(@RequestParam String message) {
        kafkaProducer.sendStringMessage(STRING_TOPIC, message);
        return "String sent!";
    }
}

