package com.codewithdinh.ecommerce.order.domain.repository;

import com.codewithdinh.ecommerce.order.application.dto.OrderResponse;
import com.codewithdinh.ecommerce.order.domain.model.Order;

import java.util.Collection;
import java.util.List;

public interface OrderRepository {
    Order saveOrderIntoDatabase(Order order);

    List<Order> findAllOrder();

    Order findOrderById(Integer orderId);
}
