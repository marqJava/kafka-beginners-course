package io.conduktor.demos.io.conduktor.demos.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {

    private static final Logger log = LoggerFactory.getLogger(ConsumerDemo.class.getSimpleName());

    public static void main(String[] args) {
        log.info("I am a Kafka Consumer");

        String groupId = "my-java-application";
        String topic = "demo_java";

        //create producer properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "cluster.playground.cdkt.io:9092");
        properties.setProperty("security.protocol", "SASL_SSL");
        properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"zH7jSxqVT9apBy9jkfBkv\" password=\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiJ6SDdqU3hxVlQ5YXBCeTlqa2ZCa3YiLCJvcmdhbml6YXRpb25JZCI6NzYyMjAsInVzZXJJZCI6ODg2OTMsImZvckV4cGlyYXRpb25DaGVjayI6ImJhNjBhMjc5LTg5ZDgtNDdjMi04ZTRjLWI3ZjljNjU1ODYwNiJ9fQ.tNJVjAR1CGsrHJFkQDW4KrVJWTpwleFTQ06mAhXTCLo\";");
        properties.setProperty("sasl.mechanism", "PLAIN");

        //create consumer configs
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());
        properties.setProperty("group.id", groupId);
        properties.setProperty("auto.offset.reset", "earliest");

        //create the Consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        //subscribe to a topic
        consumer.subscribe(Arrays.asList(topic));

        while (true) {
            log.info("Polling");
            ConsumerRecords<String, String> records
                    = consumer.poll(Duration.ofMillis(1000));

            for (ConsumerRecord<String, String> record : records) {
                log.info("Key: " + record.key() + ", Value: " + record.value());
                log.info("Partition: " + record.partition() + ", Offset: " + record.offset());

            }
        }
    }
}
