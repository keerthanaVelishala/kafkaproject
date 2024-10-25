package org.example.kafkaproject.orderservice.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.user-random-topic}")
    private String KAFKA_ORDER_CREATED_TOPIC;
    @Bean
    public NewTopic getOrderCreatedTopic(){
        return new NewTopic(KAFKA_ORDER_CREATED_TOPIC,3,(short) 1);
    }
}
