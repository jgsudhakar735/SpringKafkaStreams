/**
 * 
 */
package com.jgsudhakar.springevents.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author Sanvi Sriyaan Date 29-Mar-2023 File:
 *         com.jgsudhakar.springevents.producer.config.ProducerUtil.java This
 *         class used to
 */
@Component
public class ProducerUtil<T> {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private KafkaTemplate<String, String> kafkaNotificationTemplate;

	public void sendMessage(String topic, T object) throws JsonProcessingException {
		Map<String, Object> headers = new HashMap<>();
		headers.put("kafka_topic", topic);
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = (Map<String, Object>) objectMapper.convertValue(object, Map.class);
		map.put("topicName", topic);
		this.kafkaTemplate.send((Message) new GenericMessage(objectMapper.writeValueAsString(map), headers));
	}

	public void sendNotificationMessage(String topic, T object) throws JsonProcessingException {
		Map<String, Object> headers = new HashMap<>();
		headers.put("kafka_topic", topic);
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = (Map<String, Object>) objectMapper.convertValue(object, Map.class);
		map.put("topicName", topic);
		this.kafkaNotificationTemplate.send((Message) new GenericMessage(objectMapper.writeValueAsString(map), headers));
	}

}
