package com.codewithdinh.ecommerce.notification.infrastructure.kafka;

import com.codewithdinh.ecommerce.notification.application.service.EmailService;
import com.codewithdinh.ecommerce.notification.domain.model.notification.Notification;
import com.codewithdinh.ecommerce.notification.domain.model.order.OrderConfirmation;
import com.codewithdinh.ecommerce.notification.domain.model.payment.PaymentConfirmation;
import com.codewithdinh.ecommerce.notification.domain.repository.NotificationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.codewithdinh.ecommerce.notification.domain.model.notification.NotificationType.ORDER_NOTIFICATION;
import static com.codewithdinh.ecommerce.notification.domain.model.notification.NotificationType.PAYMENT_NOTIFICATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository repository;
    private final EmailService service;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentNotification(String notification) throws MessagingException, JsonProcessingException {
        log.info("Received Payment Notification: {}", notification);
        PaymentConfirmation orderConfirmation = objectMapper.readValue(notification, PaymentConfirmation.class);
        //save notification
        repository.saveNotificationIntoDatabase(
                Notification.builder()
                        .notificationType(PAYMENT_NOTIFICATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(orderConfirmation)
                        .build()
        );
        //sendEmail
        String customerName = orderConfirmation.customerFirstname() + " " + orderConfirmation.customerLastname();
        service.sendPaymentSuccessEmail(
                orderConfirmation.customerEmail(),
                customerName,
                orderConfirmation.amount(),
                orderConfirmation.orderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderNotification(String notification) throws JsonProcessingException, MessagingException {
        log.info("Received Order Notification: {}", notification);
        OrderConfirmation orderConfirmation = objectMapper.readValue(notification, OrderConfirmation.class);
        //save notification
        repository.saveNotificationIntoDatabase(
                Notification.builder()
                        .notificationType(ORDER_NOTIFICATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        //sendEmail
        String customerName = orderConfirmation.customer().firstName() + " " + orderConfirmation.customer().lastName();
        service.sendOrderSuccessEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );
    }
}
