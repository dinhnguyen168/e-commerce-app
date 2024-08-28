package com.codewithdinh.ecommerce.order.application.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Slf4j
public class KafkaOrderTopicConfig {
    @Bean
    public NewTopic ordersTopic() {
        log.info("INFO - Creating topic for orders");
        return TopicBuilder
                .name("order-topic")
                .build();
    }
}
