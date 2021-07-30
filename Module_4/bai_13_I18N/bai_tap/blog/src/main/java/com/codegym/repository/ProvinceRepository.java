package com.codegym.repository;

import com.codegym.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {

    Province findOne(Long id);

    void delete(Long id);
}
