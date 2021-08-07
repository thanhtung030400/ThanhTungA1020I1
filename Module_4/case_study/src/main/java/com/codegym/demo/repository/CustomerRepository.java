package com.codegym.demo.repository;


import com.codegym.demo.model.Customer;
import com.codegym.demo.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByCustomerType(CustomerType customerType);
    Page<Customer> findAllByCustomerNameContaining(String customerName, Pageable pageable);
}
