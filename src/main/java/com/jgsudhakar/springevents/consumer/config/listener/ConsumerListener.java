package com.jgsudhakar.springevents.consumer.config.listener;

import com.jgsudhakar.springevents.common.model.StudentInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springevents.consumer.config.listener.ConsumerListener
 * Date    : 29-03-2023
 * Version : 1.0
 **************************************/

@Component
@Log4j2
public class ConsumerListener {

    @KafkaListener(topics = "student-notification",
            groupId = "test-consumer-group",
    containerFactory = "kafkaListenerContainerFactory")
    public void consume(String studentInfo) {
        log.info(String.format("Message recieved -> %s", studentInfo));
    }

}
