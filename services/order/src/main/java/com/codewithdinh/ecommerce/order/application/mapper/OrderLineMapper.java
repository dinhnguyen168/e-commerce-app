package com.codewithdinh.ecommerce.order.application.mapper;

import com.codewithdinh.ecommerce.order.application.dto.OrderLineRequest;
import com.codewithdinh.ecommerce.order.application.dto.OrderLineResponse;
import com.codewithdinh.ecommerce.order.domain.model.Order;
import com.codewithdinh.ecommerce.order.domain.model.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .productId(request.productId())
                .quantity(request.quantity())
                .order(Order.builder()
                        .id(request.orderId())
                        .build())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return OrderLineResponse.builder()
                .id(orderLine.getId())
                .quantity(orderLine.getQuantity())
                .build();
    }
}
