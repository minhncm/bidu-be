package com.vn.bidu.service;

import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.dto.response.ShopResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    ProductResponse getProductById(int id);
    boolean createProduct( ProductRequest productRequest, List<MultipartFile> images);
    boolean updateProduct(int id, ProductRequest productRequest, List<MultipartFile> images);
    void deleteProduct(int id);

}
