package com.codegym.demo.repository;

import com.codegym.demo.model.RentType;
import com.codegym.demo.model.Service;
import com.codegym.demo.model.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service, Long> {
    Iterable<ServiceType> findAllByServiceType(ServiceType serviceType);
    Iterable<RentType> findAllByRentType(RentType rentType);
    Page<Service> findAllByServiceNameContaining(String serviceName, Pageable pageable);
}
