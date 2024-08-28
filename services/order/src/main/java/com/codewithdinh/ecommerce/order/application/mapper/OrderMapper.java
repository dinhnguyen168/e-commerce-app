package com.codewithdinh.ecommerce.order.application.mapper;

import com.codewithdinh.ecommerce.order.application.dto.OrderRequest;
import com.codewithdinh.ecommerce.order.application.dto.OrderResponse;
import com.codewithdinh.ecommerce.order.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order toOrder(OrderRequest orderRequest) {
        return Order.builder()
                .id(orderRequest.id())
                .customerId(orderRequest.customerId())
                .reference(orderRequest.reference())
                .totalAmount(orderRequest.amount())
                .paymentMethod(orderRequest.paymentMethod())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .reference(order.getReference())
                .totalAmount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .build();
    }
}
