package com.jgsudhakar.springevents.streams.config;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

import java.util.Properties;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springevents.streams.config.KafkaStreamConfiguration
 * Date    : 03-04-2023
 * Version : 1.0
 **************************************/

@Configuration
@EnableKafkaStreams
public class KafkaStreamConfiguration {

    @Autowired
    public void streams() {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"student");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG,0);

        StreamsBuilder builder = new StreamsBuilder();
        builder.<String,String>stream("student").
                to("student-notification", Produced.with(Serdes.String(),Serdes.String()));
        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(),properties);
        kafkaStreams.start();
    }

    @Bean
    public KStream<String, String> kStream(StreamsBuilder kStreamBuilder) {
        KStream<String, String> stream = kStreamBuilder.stream("student");
        stream.foreach((K, v) -> { });
        return stream;
    }

}
