package com.vn.bidu.repository;

import com.vn.bidu.entity.SizeColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeColorRepository extends JpaRepository<SizeColor, Integer> {
}
