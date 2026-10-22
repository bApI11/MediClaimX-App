package com.mediclaimx.patientservice.config;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.mediclaimx.patientservice.event.PatientRegisteredEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String,
                PatientRegisteredEvent>
    producerFactory() {

        Map<String, Object> config =
                new HashMap<>();

        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");

        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);

        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(
                config);
    }

    @Bean
    public KafkaTemplate<String,
            PatientRegisteredEvent>
    kafkaTemplate() {

        return new KafkaTemplate<>(
                producerFactory());
    }
}