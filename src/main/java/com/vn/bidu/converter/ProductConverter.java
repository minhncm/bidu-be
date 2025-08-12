package com.vn.bidu.converter;

import com.vn.bidu.dto.response.CategoryResponse;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.entity.Category;
import com.vn.bidu.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper mapper;

    public ProductResponse toProductResponse(Product product) {
        return mapper.map(product, ProductResponse.class);
    }
}
