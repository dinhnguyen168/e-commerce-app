package com.codewithdinh.ecommerce.customer.application.mapper;

import com.codewithdinh.ecommerce.customer.application.dto.CustomerRequest;
import com.codewithdinh.ecommerce.customer.application.dto.CustomerResponse;
import com.codewithdinh.ecommerce.customer.domain.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customer) {
        return Customer.builder()
                .id(customer.id())
                .firstName(customer.firstName())
                .lastName(customer.lastName())
                .address(customer.address())
                .email(customer.email())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
