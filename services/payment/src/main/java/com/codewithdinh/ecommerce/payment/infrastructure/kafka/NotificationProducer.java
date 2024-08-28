package com.codewithdinh.ecommerce.payment.infrastructure.kafka;

import com.codewithdinh.ecommerce.payment.application.dto.PaymentNotificationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendNotification(PaymentNotificationRequest request) throws JsonProcessingException {
        String jsonPaymentNotificationRequest = objectMapper.writeValueAsString(request);
        kafkaTemplate.send("payment-topic", jsonPaymentNotificationRequest);
//        Message<PaymentNotificationRequest> message = MessageBuilder
//                .withPayload(request)
//                .setHeader(TOPIC, "payment-topic")
//                .build();
//        kafkaTemplate.send(message);
        log.info("INFO - Payment confirmation with topic payment-order");
    }
}
