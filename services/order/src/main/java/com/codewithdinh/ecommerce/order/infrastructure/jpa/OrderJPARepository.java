package com.codewithdinh.ecommerce.order.infrastructure.jpa;

import com.codewithdinh.ecommerce.order.domain.exception.OrderNotFoundException;
import com.codewithdinh.ecommerce.order.domain.model.Order;
import com.codewithdinh.ecommerce.order.domain.repository.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.lang.String.format;

@Repository
public interface OrderJPARepository extends JpaRepository<Order, Integer>, OrderRepository {
    default Order saveOrderIntoDatabase(Order order) {
        return save(order);
    };

    default List<Order> findAllOrder() {
        return findAll();
    };

    default Order findOrderById(Integer orderId) {
        return findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(format("Order with id %s not found", orderId)));
    };
}
