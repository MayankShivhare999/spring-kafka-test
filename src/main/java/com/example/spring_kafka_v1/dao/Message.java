package com.example.spring_kafka_v1.dao;

import lombok.Data;

import java.util.UUID;

@Data
public class Message {
    private int id;
    private String content;
}
