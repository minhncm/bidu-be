package com.vn.bidu.service.impl;

import com.vn.bidu.converter.CategoryConverter;
import com.vn.bidu.converter.ProductConverter;
import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.entity.Product;
import com.vn.bidu.repository.ProductRepository;
import com.vn.bidu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;
    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
        for(Product product : products){
            ProductResponse productResponse = productConverter.toProductResponse(product);
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }

    @Override
    public ProductResponse getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return productConverter.toProductResponse(product);
    }

    @Override
    public boolean updateProduct(int id, ProductRequest productRequest) {

        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){
            Product newProduct =  productConverter.toProductEntity(productRequest, product.get());

            productRepository.save(newProduct);

            return true;
        }else{
            throw new RuntimeException("Product not found");
        }

    }

    @Override
    public void deleteProduct(int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
        }else{
            throw new RuntimeException("Product not found");
        }
    }
}
