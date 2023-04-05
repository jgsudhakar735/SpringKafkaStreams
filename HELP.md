# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.4/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#using.devtools)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web)
* [Apache Kafka Streams Support](https://docs.spring.io/spring-kafka/docs/current/reference/html/#streams-kafka-streams)
* [Apache Kafka Streams Binding Capabilities of Spring Cloud Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#_kafka_streams_binding_capabilities_of_spring_cloud_stream)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#messaging.kafka)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Samples for using Apache Kafka Streams with Spring Cloud stream](https://github.com/spring-cloud/spring-cloud-stream-samples/tree/master/kafka-streams-samples)

### Creating Topics
D:\kafka_2.13-3.4.0\bin\windows> .\kafka-topics.bat --create --topic student --bootstrap-server localhost:9092
Created topic student.

D:\kafka_2.13-3.4.0\bin\windows> .\kafka-topics.bat --create --topic student-register --bootstrap-server localhost:9092
Created topic student-register.

D:\kafka_2.13-3.4.0\bin\windows> .\kafka-topics.bat --create --topic student-notification --bootstrap-server localhost:9092
Created topic student-notification.