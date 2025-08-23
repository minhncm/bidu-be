package com.vn.bidu.repository;

import com.vn.bidu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findTop3ByNameProductContaining(String keyword);
}
