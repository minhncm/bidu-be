package com.vn.bidu.repository;

import com.vn.bidu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findTop3ByFullNameContaining(String keyword);
}
