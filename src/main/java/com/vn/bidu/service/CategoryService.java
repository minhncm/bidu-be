package com.vn.bidu.service;

import com.vn.bidu.dto.response.CategoryResponse;
import com.vn.bidu.dto.response.ShopResponse;

import java.util.List;
import java.util.Optional;

public interface  CategoryService {
    List<CategoryResponse> getAllCategory();
    CategoryResponse getById(int id);
    void deleteCategory(int id);
}
