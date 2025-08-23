package com.vn.bidu.service;

import com.vn.bidu.dto.response.UserResponse;
import com.vn.bidu.dto.response.VariantResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUser();
    UserResponse getUserById(int id);
    List<UserResponse>getUserByName(String name);
}
