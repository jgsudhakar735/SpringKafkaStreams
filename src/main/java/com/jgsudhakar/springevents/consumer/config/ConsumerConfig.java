package com.jgsudhakar.springevents.consumer.config;

import com.jgsudhakar.springevents.common.model.StudentInfo;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springevents.consumer.config.KafkaConsumerConfig
 * Date    : 29-03-2023
 * Version : 1.0
 **************************************/

@Configuration
@EnableKafka
public class ConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServer;

    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    @Bean
    public ConsumerFactory<String, StudentInfo> infoConsumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, null, new JsonDeserializer<StudentInfo>(StudentInfo.class));
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, StudentInfo>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, StudentInfo> listener = new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(infoConsumerFactory());
        return listener;
    }
}
