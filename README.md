# SpringKafkaStreams
This is a sample application on how to use Kafka Stream to send from on topic to another topic as per business use cases

# Getting Started

### Creating Topics
D:\kafka_2.13-3.4.0\bin\windows> .\kafka-topics.bat --create --topic student --bootstrap-server localhost:9092
Created topic student.

D:\kafka_2.13-3.4.0\bin\windows> .\kafka-topics.bat --create --topic student-register --bootstrap-server localhost:9092
Created topic student-register.

D:\kafka_2.13-3.4.0\bin\windows> .\kafka-topics.bat --create --topic student-notification --bootstrap-server localhost:9092
Created topic student-notification.
