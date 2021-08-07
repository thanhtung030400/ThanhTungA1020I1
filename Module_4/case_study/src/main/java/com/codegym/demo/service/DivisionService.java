package com.codegym.demo.service;

import com.codegym.demo.model.Division;

public interface DivisionService {
    Iterable<Division> findAll();
    Division findById(Long id);
    void save(Division division);
}
