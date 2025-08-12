package com.vn.bidu.service.impl;

import com.vn.bidu.converter.CategoryConverter;
import com.vn.bidu.dto.response.CategoryResponse;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Category;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.repository.CategoryRepository;
import com.vn.bidu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;
    @Override
    public List<CategoryResponse> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse>  categoryResponseList = new ArrayList<>();

        for(Category category : categories){
            CategoryResponse categoryResponse = categoryConverter.toCategoryResponse(category);
            categoryResponseList.add(categoryResponse);
        }
        return categoryResponseList;
    }

    @Override
    public CategoryResponse getById(int id) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryConverter.toCategoryResponse(category);

    }
}
