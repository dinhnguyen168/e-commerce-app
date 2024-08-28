package com.codewithdinh.ecommerce.order.application.service;

import com.codewithdinh.ecommerce.order.application.dto.OrderLineRequest;
import com.codewithdinh.ecommerce.order.application.dto.OrderLineResponse;

import java.util.List;

public interface OrderLineService {
    Integer saveOrderLine(OrderLineRequest build);

    List<OrderLineResponse> findAllOrderLineByOrderId(Integer orderId);
}
