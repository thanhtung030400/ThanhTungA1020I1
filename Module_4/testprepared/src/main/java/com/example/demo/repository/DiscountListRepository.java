package com.example.demo.repository;

import com.example.demo.model.DiscountList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DiscountListRepository extends PagingAndSortingRepository<DiscountList, Long> {
    @Query("select e from DiscountList e where e.name like %?1%")
    Page<DiscountList> findAllByNameContaining(String name, Pageable pageable);
}
