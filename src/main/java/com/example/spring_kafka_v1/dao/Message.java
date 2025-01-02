package com.example.spring_kafka_v1.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Message {
    private UUID id;
    private String content;
}
