package com.codewithdinh.ecommerce.order.application.service;

import com.codewithdinh.ecommerce.order.application.dto.OrderLineRequest;
import com.codewithdinh.ecommerce.order.application.dto.OrderLineResponse;
import com.codewithdinh.ecommerce.order.application.mapper.OrderLineMapper;
import com.codewithdinh.ecommerce.order.domain.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    @Override
    public Integer saveOrderLine(OrderLineRequest request) {
        var orderLine = mapper.toOrderLine(request);
        return repository.saveOrderLine(orderLine).getId();
    }

    @Override
    public List<OrderLineResponse> findAllOrderLineByOrderId(Integer orderId) {
        return repository.findAllOrderLineByOrderId(orderId).stream()
                .map(mapper::toOrderLineResponse)
                .toList();
    }
}
