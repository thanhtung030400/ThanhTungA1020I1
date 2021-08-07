package com.codegym.demo.service;

import com.codegym.demo.model.EducationDegree;

public interface EducationDegreeService {
    Iterable<EducationDegree> findAll();
    EducationDegree findById(Long id);
    void save(EducationDegree educationDegree);
}
