package com.codegym.demo.service;

import com.codegym.demo.model.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    ContractDetail findById(Long id);
    void save(ContractDetail contractDetail);
    void delete(Long contractDetailId);
}
