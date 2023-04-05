package com.jgsudhakar.springevents.producer.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jgsudhakar.springevents.common.model.StudentInfo;
import com.jgsudhakar.springevents.producer.config.ProducerUtil;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springevents.producer.service.KafkaProduceService
 * Date    : 25-03-2023
 * Version : 1.0
 **************************************/

@Service
public class StudentService {
    private static final String TOPIC = "student";
    private static final String TOPIC_NOTIFICTAION = "student-register";

        @Autowired
        private ProducerUtil<StudentInfo> producerUtil;

        public StudentInfo register(StudentInfo studentInfo) throws JsonProcessingException {
            studentInfo.setUniqueId(UUID.randomUUID().toString().toUpperCase());
            producerUtil.sendMessage(TOPIC, studentInfo);
            producerUtil.sendNotificationMessage(TOPIC_NOTIFICTAION, studentInfo);
            return studentInfo;
        }
}
