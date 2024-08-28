package com.codewithdinh.ecommerce.order.infrastructure.jpa;

import com.codewithdinh.ecommerce.order.domain.model.OrderLine;
import com.codewithdinh.ecommerce.order.domain.repository.OrderLineRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineJPARepository extends JpaRepository<OrderLine, Integer>, OrderLineRepository {
    default OrderLine saveOrderLine(OrderLine orderLine) {
        return save(orderLine);
    }

    List<OrderLine> findAllByOrderId(Integer orderId);

    default List<OrderLine> findAllOrderLineByOrderId(Integer orderId) {
        return this.findAllByOrderId(orderId);
    }
}
