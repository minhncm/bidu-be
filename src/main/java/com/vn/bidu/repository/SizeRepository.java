package com.vn.bidu.repository;

import com.vn.bidu.entity.Shop;
import com.vn.bidu.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
}
