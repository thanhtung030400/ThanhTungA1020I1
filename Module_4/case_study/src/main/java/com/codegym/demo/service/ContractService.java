package com.codegym.demo.service;

import com.codegym.demo.model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    Contract findById(Long contractId);
    void save(Contract contract);
    void delete(Long contractId);
}
