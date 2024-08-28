package com.codewithdinh.ecommerce.payment.application.service;

import com.codewithdinh.ecommerce.payment.application.dto.PaymentNotificationRequest;
import com.codewithdinh.ecommerce.payment.application.dto.PaymentRequest;
import com.codewithdinh.ecommerce.payment.application.mapper.PaymentMapper;
import com.codewithdinh.ecommerce.payment.domain.repository.PaymentRepository;
import com.codewithdinh.ecommerce.payment.infrastructure.kafka.NotificationProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    @Override
    public Integer createPayment(PaymentRequest request) throws JsonProcessingException {
        var payment = repository.savePaymentIntoDatabase(mapper.toPayment(request));
        notificationProducer.sendNotification(
                PaymentNotificationRequest.builder()
                        .orderReference(request.orderReference())
                        .amount(request.amount())
                        .paymentMethod(request.paymentMethod())
                        .customerFirstname(request.customer().firstname())
                        .customerLastname(request.customer().lastname())
                        .customerEmail(request.customer().email())
                        .build()
        );

        return payment.getId();
    }
}
