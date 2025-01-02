# Spring Kafka V1

## Overview

This project is a Spring Boot application that demonstrates how to produce and consume messages using Apache Kafka.

## Prerequisites

- Java 11 or higher
- Apache Kafka
- Maven
- Docker

## Setup

1. **Clone the repository:**
    ```sh
    git clone https://github.com/MayankShivhare999/spring_kafka_v1.git
    cd spring_kafka_v1
    ```

2. **Install dependencies:**
    ```sh
    mvn clean install
    ```

3. **Configure Kafka:**
    Ensure Kafka is running on `localhost:9092`. You can update the Kafka server details in `src/main/resources/application.properties` if needed.

4. **Setup Kafka using Docker:**
    Create a `docker-compose.yml` file in the root directory of your project with the following content:
    ```yaml
    version: '3.8'
    services:
      zookeeper:
        image: confluentinc/cp-zookeeper:7.4.1
        container_name: zookeeper
        environment:
          ZOOKEEPER_CLIENT_PORT: 2181
          ZOOKEEPER_TICK_TIME: 2000
        ports:
          - "2181:2181"

      kafka:
        image: confluentinc/cp-kafka:7.4.1
        container_name: kafka
        ports:
          - "9092:9092"
        environment:
          KAFKA_BROKER_ID: 1
          KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
          KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
          KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
        depends_on:
          - zookeeper
    ```

    Then, run the following command to start Kafka and Zookeeper:
    ```sh
    docker-compose up -d
    ```

## Running the Application

To run the application, use the following command:
```sh
mvn spring-boot:run