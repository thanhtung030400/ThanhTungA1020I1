package com.codegym.demo.service.impl;

import com.codegym.demo.model.Division;
import com.codegym.demo.model.EducationDegree;
import com.codegym.demo.model.Employee;
import com.codegym.demo.model.Position;
import com.codegym.demo.repository.EmployeeRepository;
import com.codegym.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> search(String keyword, Pageable pageable) {
        return employeeRepository.search(keyword, pageable);
    }


    @Override
    public Iterable<Employee> findAllByDivision(Division division) {
        return employeeRepository.findAllByDivision(division);
    }

    @Override
    public Iterable<Employee> findAllByPosition(Position position) {
        return employeeRepository.findAllByPosition(position);
    }

    @Override
    public Iterable<Employee> findAllByEducationDegree(EducationDegree educationDegree) {
        return employeeRepository.findAllByEducationDegree(educationDegree);
    }
}
