package com.codewithdinh.ecommerce.customer.infrastructure.mongo;

import com.codewithdinh.ecommerce.customer.domain.exception.CustomerNotFoundException;
import com.codewithdinh.ecommerce.customer.domain.model.Customer;
import com.codewithdinh.ecommerce.customer.domain.repository.CustomerRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMongoRepository extends MongoRepository<Customer, String>, CustomerRepository {

    default Customer findCustomerById(String id) {
        return findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id" + id + " not found"));
    }

    default Customer saveCustomerToDatabase(Customer customer) {
        return save(customer);
    }

    default List<Customer> findAllCustomers() {
        return findAll();
    }

    default Boolean existsCustomerById(String id) {
        return findById(id).isPresent();
    }

    default void deleteCustomerByIdFromDatabase(String id) {
        deleteById(id);
    }
}
