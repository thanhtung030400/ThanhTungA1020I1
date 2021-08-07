package com.codegym.demo.service;

import com.codegym.demo.model.RentType;

public interface RentTypeService {
    Iterable<RentType> findAll();
    RentType findById(Long id);
    void save(RentType rentType);
}
