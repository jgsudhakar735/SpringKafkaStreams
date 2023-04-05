package com.jgsudhakar.springevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class SpringEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEventsApplication.class, args);
    }

}
