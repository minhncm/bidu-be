package com.vn.bidu.service;

import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.dto.response.ShopResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    ProductResponse getProductById(int id);
    boolean updateProduct(int id, ProductRequest productRequest);
    void deleteProduct(int id);
}
