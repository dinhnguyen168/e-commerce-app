package com.codewithdinh.ecommerce.customer.infrastructure.web;

import com.codewithdinh.ecommerce.customer.application.dto.CustomerRequest;
import com.codewithdinh.ecommerce.customer.application.dto.CustomerResponse;
import com.codewithdinh.ecommerce.customer.application.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public String createCustomer(@RequestBody @Valid CustomerRequest customer) {
        return service.createCustome(customer);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void updateCustomer(@RequestBody @Valid CustomerRequest customer) {
        service.updateCustomer(customer);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerResponse> getCustomers() {
        return service.findAllCustomers();
    }

    @GetMapping("/test")
    @ResponseStatus(value = HttpStatus.OK)
    public String getString() {
        return "service.findAllCustomers()";
    }

    @GetMapping("/exists/{customer_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Boolean existsById(@PathVariable("customer_id") String customerId) {
        return service.existsById(customerId);
    }

    @GetMapping("/{customer_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerResponse findById(@PathVariable("customer_id") String customerId) {
        return service.findById(customerId);
    }

    @DeleteMapping("/{customer_id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable("customer_id") String customerId) {
        service.deleteById(customerId);
    }
}
