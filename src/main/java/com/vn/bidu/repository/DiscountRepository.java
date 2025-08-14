package com.vn.bidu.repository;

import com.vn.bidu.entity.DiscountBidu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountBidu, Integer> {
}
