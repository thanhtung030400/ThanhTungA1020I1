package com.codegym.demo.service;

import com.codegym.demo.model.ServiceType;

public interface ServiceTypeService {
    Iterable<ServiceType> findAll();
    ServiceType findById(Long id);
    void save(ServiceType serviceType);
}
