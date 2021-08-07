package com.codegym.demo.service.impl;

import com.codegym.demo.model.EducationDegree;
import com.codegym.demo.repository.EducationDegreeRepository;
import com.codegym.demo.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Long id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }
}
