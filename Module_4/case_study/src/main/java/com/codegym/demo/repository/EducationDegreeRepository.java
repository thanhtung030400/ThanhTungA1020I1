package com.codegym.demo.repository;

import com.codegym.demo.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Long> {
}
