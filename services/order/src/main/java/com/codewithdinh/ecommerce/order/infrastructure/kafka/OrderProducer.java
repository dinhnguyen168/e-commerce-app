package com.codewithdinh.ecommerce.order.infrastructure.kafka;

import com.codewithdinh.ecommerce.order.application.dto.OrderConfirmation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public void sendOrderConfirmation(OrderConfirmation orderConfirmation) throws JsonProcessingException {

        String jsonOrderConfirmation = objectMapper.writeValueAsString(orderConfirmation);
        kafkaTemplate.send("order-topic", jsonOrderConfirmation);

        log.info("INFO - Order confirmation with topic order-topic");
    }
}
