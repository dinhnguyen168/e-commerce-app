package com.codewithdinh.ecommerce.order.application.service;

import com.codewithdinh.ecommerce.order.application.dto.OrderRequest;
import com.codewithdinh.ecommerce.order.application.dto.OrderResponse;
import com.codewithdinh.ecommerce.order.domain.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.List;

public interface OrderService {
    Integer createOrder(OrderRequest orderRequest) throws JsonProcessingException;

    List<OrderResponse> findAllOrder();

    OrderResponse findOrderById(Integer orderId);
}
