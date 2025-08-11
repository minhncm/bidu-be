package com.vn.bidu.repository;

import com.vn.bidu.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query(value = "Select * from shop where id = ?", nativeQuery = true)
    Optional<Shop> findById(int id);
}
