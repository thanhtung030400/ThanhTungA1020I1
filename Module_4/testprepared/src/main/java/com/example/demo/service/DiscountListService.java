package com.example.demo.service;

import com.example.demo.model.DiscountList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiscountListService {
    Page<DiscountList> findAll(Pageable pageable);
    DiscountList findById(Long id);
    void save(DiscountList product);
    void remove(Long id);
    Page<DiscountList> findAllByNameContaining(String name, Pageable pageable);
}

