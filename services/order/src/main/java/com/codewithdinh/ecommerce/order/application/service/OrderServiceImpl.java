package com.codewithdinh.ecommerce.order.application.service;

import com.codewithdinh.ecommerce.order.application.dto.OrderConfirmation;
import com.codewithdinh.ecommerce.order.application.dto.OrderLineRequest;
import com.codewithdinh.ecommerce.order.application.dto.OrderRequest;
import com.codewithdinh.ecommerce.order.application.dto.OrderResponse;
import com.codewithdinh.ecommerce.order.application.dto.PaymentRequest;
import com.codewithdinh.ecommerce.order.application.dto.PurchaseRequest;
import com.codewithdinh.ecommerce.order.application.dto.PurchaseResponse;
import com.codewithdinh.ecommerce.order.application.mapper.OrderMapper;
import com.codewithdinh.ecommerce.order.domain.exception.BusinessException;
import com.codewithdinh.ecommerce.order.domain.repository.OrderRepository;
import com.codewithdinh.ecommerce.order.application.dto.CustomerResponse;
import com.codewithdinh.ecommerce.order.infrastructure.client.CustomerClient;
import com.codewithdinh.ecommerce.order.infrastructure.client.PaymentClient;
import com.codewithdinh.ecommerce.order.infrastructure.client.ProductClient;
import com.codewithdinh.ecommerce.order.infrastructure.kafka.OrderProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Override
    public Integer createOrder(OrderRequest orderRequest) throws JsonProcessingException {
        //check the customer --> using OpenFeign
        CustomerResponse customerById = customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with provided customer id"));
        //purchase the product ---> using product-service
        List<PurchaseResponse> purchasedProducts = productClient.purchaseProducts(orderRequest.products());
        //persist order
        var order = repository.saveOrderIntoDatabase(mapper.toOrder(orderRequest));
        //persist order lines
        for (PurchaseRequest purchaseRequest : orderRequest.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        //start payment process
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .amount(orderRequest.amount())
                .paymentMethod(orderRequest.paymentMethod())
                .orderId(order.getId())
                .orderReference(order.getReference())
                .customer(customerById)
                .build();
        paymentClient.requestPayment(paymentRequest);

        //send the order confirmation --> using notification-service (kafka)
        orderProducer.sendOrderConfirmation(
                OrderConfirmation.builder()
                        .orderReference(orderRequest.reference())
                        .totalAmount(orderRequest.amount())
                        .paymentMethod(orderRequest.paymentMethod())
                        .customer(customerById)
                        .products(purchasedProducts)
                        .build()
        );
        return order.getId();
    }

    @Override
    public List<OrderResponse> findAllOrder() {
        return repository.findAllOrder().stream()
                .map(mapper::fromOrder)
                .toList();
    }

    @Override
    public OrderResponse findOrderById(Integer orderId) {
        return mapper.fromOrder(repository.findOrderById(orderId));
    }
}
