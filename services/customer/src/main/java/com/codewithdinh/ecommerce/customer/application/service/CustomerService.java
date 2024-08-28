package com.codewithdinh.ecommerce.customer.application.service;

import com.codewithdinh.ecommerce.customer.application.dto.CustomerRequest;
import com.codewithdinh.ecommerce.customer.application.dto.CustomerResponse;
import com.codewithdinh.ecommerce.customer.domain.model.Customer;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public interface CustomerService {
    String createCustome(CustomerRequest request);

    void updateCustomer(CustomerRequest request);

    default void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String customerId);

    CustomerResponse findById(String customerId);

    void deleteById(String customerId);
}
