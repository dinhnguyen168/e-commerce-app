package com.codewithdinh.ecommerce.notification.domain.model.order;

import com.codewithdinh.ecommerce.notification.domain.model.customer.Customer;
import com.codewithdinh.ecommerce.notification.domain.model.payment.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
