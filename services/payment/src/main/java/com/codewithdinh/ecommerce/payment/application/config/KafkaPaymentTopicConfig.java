package com.codewithdinh.ecommerce.payment.application.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Slf4j
public class KafkaPaymentTopicConfig {
    @Bean
    public NewTopic paymentTopic() {
        log.info("INFO - Creating topic for payment topic");
        return TopicBuilder.name("payment-topic").build();
    }
}
