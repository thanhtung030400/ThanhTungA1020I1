package com.codegym.service;

import com.codegym.model.DiscountList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiscountListService {
    Page<DiscountList> findAll(Pageable pageable);
    DiscountList findById(Long id);
    void save(DiscountList discountList);
    void remove(Long id);
    Page<DiscountList> findAllByNameContaining(String title, Pageable pageable);
}
