package com.jgsudhakar.springevents.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springevents.producer.config.KafkaProducerConfig
 * Date    : 18-03-2023
 * Version : 1.0
 **************************************/

@Configuration
public class ProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServer;

    @Bean
    public ProducerFactory<String, String> producerStudentFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServer);
        config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerStudentFactory) {
        return new KafkaTemplate<>(producerStudentFactory);
    }
}
