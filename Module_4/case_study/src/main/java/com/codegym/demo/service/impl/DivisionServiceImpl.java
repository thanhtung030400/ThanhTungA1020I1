package com.codegym.demo.service.impl;

import com.codegym.demo.model.Division;
import com.codegym.demo.repository.DivisionRepository;
import com.codegym.demo.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements DivisionService{
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }
}
