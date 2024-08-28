package com.codewithdinh.ecommerce.order.infrastructure.web;

import com.codewithdinh.ecommerce.order.application.dto.OrderLineResponse;
import com.codewithdinh.ecommerce.order.application.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService service;

    @GetMapping("/order/{order-id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderLineResponse> findByOrderId(@PathVariable("order-id") Integer orderId) {
        return service.findAllOrderLineByOrderId(orderId);
    }
}
