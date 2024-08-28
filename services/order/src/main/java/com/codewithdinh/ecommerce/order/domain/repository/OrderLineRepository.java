package com.codewithdinh.ecommerce.order.domain.repository;

import com.codewithdinh.ecommerce.order.domain.model.OrderLine;

import java.util.List;

public interface OrderLineRepository {
    OrderLine saveOrderLine(OrderLine orderLine);

    List<OrderLine> findAllOrderLineByOrderId(Integer orderId);
}
