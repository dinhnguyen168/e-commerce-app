package com.codewithdinh.ecommerce.customer.application.service;

import com.codewithdinh.ecommerce.customer.application.dto.CustomerRequest;
import com.codewithdinh.ecommerce.customer.application.dto.CustomerResponse;
import com.codewithdinh.ecommerce.customer.application.mapper.CustomerMapper;
import com.codewithdinh.ecommerce.customer.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public String createCustome(CustomerRequest request) {
        var customer = repository.saveCustomerToDatabase(mapper.toCustomer(request));
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        var customer = repository.findCustomerById(request.id());
        mergeCustomer(customer, request);
        repository.saveCustomerToDatabase(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return repository.findAllCustomers().stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(String customerId) {
        return repository.existsCustomerById(customerId);
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return mapper.fromCustomer(repository.findCustomerById(customerId));
    }

    @Override
    public void deleteById(String customerId) {
        repository.deleteCustomerByIdFromDatabase(customerId);
    }
}
