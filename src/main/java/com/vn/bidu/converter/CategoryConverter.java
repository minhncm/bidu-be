package com.vn.bidu.converter;

import com.vn.bidu.dto.response.CategoryResponse;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Category;
import com.vn.bidu.entity.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    @Autowired
    private ModelMapper mapper;

    public CategoryResponse toCategoryResponse(Category category) {
        return mapper.map(category, CategoryResponse.class);
    }
}
