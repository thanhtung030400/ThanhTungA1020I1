package com.codegym.demo.service;

import com.codegym.demo.model.Customer;
import com.codegym.demo.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    void save(Customer customer);
    void remove(Long id);
    Iterable<Customer> findAllByCustomerType(CustomerType customerType);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
