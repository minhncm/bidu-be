package com.vn.bidu.repository;

import com.vn.bidu.dto.request.ProductFilterRequest;
import com.vn.bidu.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> filterMultiCriteria(ProductFilterRequest request);
}
