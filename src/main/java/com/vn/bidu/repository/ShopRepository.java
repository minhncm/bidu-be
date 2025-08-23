package com.vn.bidu.repository;

import com.vn.bidu.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query(value = "Select * from shop where id = ?", nativeQuery = true)
    Optional<Shop> findById(int id);
    List<Shop> findTop3ByNameShopContaining(String keyword);
}
