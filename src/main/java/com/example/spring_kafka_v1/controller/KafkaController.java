package com.example.spring_kafka_v1.controller;

import com.example.spring_kafka_v1.dao.Message;
import com.example.spring_kafka_v1.producer.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        Message messageObj = new Message();
        messageObj.setId(1);
        messageObj.setContent(message);
        kafkaProducer.sendMessage("my-topic", messageObj);
        return "Message sent!";
    }
}

