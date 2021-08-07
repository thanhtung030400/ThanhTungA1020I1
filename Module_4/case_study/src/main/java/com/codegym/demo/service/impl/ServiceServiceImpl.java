package com.codegym.demo.service.impl;

import com.codegym.demo.repository.ServiceRepository;
import com.codegym.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Iterable<com.codegym.demo.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public com.codegym.demo.model.Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(com.codegym.demo.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }

    @Override
    public Page<com.codegym.demo.model.Service> findAllByServiceNameContaining(String serviceName, Pageable pageable) {
        return serviceRepository.findAllByServiceNameContaining(serviceName, pageable);
    }
}
