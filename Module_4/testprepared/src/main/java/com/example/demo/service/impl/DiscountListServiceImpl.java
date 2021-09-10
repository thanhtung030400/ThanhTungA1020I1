package com.example.demo.service.impl;

import com.example.demo.model.DiscountList;
import com.example.demo.repository.DiscountListRepository;
import com.example.demo.service.DiscountListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiscountListServiceImpl implements DiscountListService {
    @Autowired
    private DiscountListRepository discountListRepository;

    @Override
    public Page<DiscountList> findAll(Pageable pageable) {
        return discountListRepository.findAll(pageable);
    }

    @Override
    public DiscountList findById(Long id) {
        return discountListRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DiscountList discountList) {
        discountListRepository.save(discountList);

    }

    @Override
    public void remove(Long id) {
        discountListRepository.deleteById(id);

    }


    @Override
    public Page<DiscountList> findAllByNameContaining(String name, Pageable pageable) {
        return discountListRepository.findAllByNameContaining(name, pageable);
    }
}
