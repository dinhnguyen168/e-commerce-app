package com.codewithdinh.ecommerce.payment.application.mapper;

import com.codewithdinh.ecommerce.payment.application.dto.PaymentRequest;
import com.codewithdinh.ecommerce.payment.domain.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment toPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .id(paymentRequest.id())
                .amount(paymentRequest.amount())
                .orderId(paymentRequest.orderId())
                .paymentMethod(paymentRequest.paymentMethod())
                .build();
    }
}
