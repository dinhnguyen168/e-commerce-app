package com.codewithdinh.ecommerce.order.infrastructure.web;

import com.codewithdinh.ecommerce.order.application.dto.OrderRequest;
import com.codewithdinh.ecommerce.order.application.dto.OrderResponse;
import com.codewithdinh.ecommerce.order.application.mapper.OrderMapper;
import com.codewithdinh.ecommerce.order.application.service.OrderService;
import com.codewithdinh.ecommerce.order.domain.exception.OrderNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer createOrder(@RequestBody @Valid OrderRequest orderRequest) throws JsonProcessingException {
        return service.createOrder(orderRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> findAll() {
        return service.findAllOrder();
    }

    @GetMapping("/{order-id}")
    public OrderResponse findById(@PathVariable("order-id") Integer orderId) {
        return service.findOrderById(orderId);
    }

}
