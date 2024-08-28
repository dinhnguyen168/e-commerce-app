package com.codewithdinh.ecommerce.customer.domain.repository;

import com.codewithdinh.ecommerce.customer.domain.model.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer findCustomerById(String customerId);

    Customer saveCustomerToDatabase(Customer customer);

    List<Customer> findAllCustomers();

    Boolean existsCustomerById(String customerId);

    void deleteCustomerByIdFromDatabase(String customerId);
}
