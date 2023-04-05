package com.jgsudhakar.springevents.producer.config;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springevents.producer.config.STudentNotificationProducerConfig
 * Date    : 03-04-2023
 * Version : 1.0
 **************************************/

@Configuration
public class StudentNotificationProducerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServer;

    @Bean("kafkaStudentProduceService")
    public ProducerFactory<String, String> producerStudentNotificationFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServer);
        config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaNotificationTemplate(ProducerFactory<String, String> kafkaStudentProduceService) {
        return new KafkaTemplate<>(kafkaStudentProduceService);
    }
}
