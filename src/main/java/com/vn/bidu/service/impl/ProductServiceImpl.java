package com.vn.bidu.service.impl;

import com.vn.bidu.converter.CategoryConverter;
import com.vn.bidu.converter.ProductConverter;
import com.vn.bidu.converter.VariantConverter;
import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.dto.request.VariantRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.entity.DiscountBidu;
import com.vn.bidu.entity.Product;
import com.vn.bidu.entity.Variant;
import com.vn.bidu.repository.DiscountRepository;
import com.vn.bidu.repository.ProductRepository;
import com.vn.bidu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final DiscountRepository discountRepository;
    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private VariantConverter variantConverter;

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
        try {
            Optional<Product> product = productRepository.findById(id);

            Set<DiscountBidu> discountBidus = new HashSet<>();
            Set<Variant> variants = new HashSet<>();

            for(int discountId : productRequest.getDiscountIds()) {

                DiscountBidu discountBidu = discountRepository.findById(discountId).orElseThrow(() -> new RuntimeException("Discount not found"));
                discountBidus.add(discountBidu);
            }

            for(VariantRequest variantRequest : productRequest.getVariants() ){
                Variant variant = variantConverter.toVariantEntity(variantRequest);
                variants.add(variant);
            }

            if(product.isPresent()){
                Product newProduct =  productConverter.toProductEntity(productRequest, product.get(),discountBidus, variants );
                productRepository.save(newProduct);
                return true;
            }


        } catch (Exception e) {
            throw new RuntimeException("Product not found");

        }
        return false;
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

    @Override
    public boolean createProduct( ProductRequest productRequest) {
        try {
            Set<DiscountBidu> discountBidus = new HashSet<>();
            Set<Variant> variants = new HashSet<>();
            for(int discountId : productRequest.getDiscountIds()) {
                DiscountBidu discountBidu = discountRepository.findById(discountId)
                        .orElseThrow(() -> new RuntimeException("Discount not found"));
                discountBidus.add(discountBidu);
            }

            for(VariantRequest variantRequest : productRequest.getVariants() ){
                Variant variant = variantConverter.toVariantEntity(variantRequest);
                variants.add(variant);
            }
                Product product = productConverter.toProductEntity(productRequest, new Product(),discountBidus,variants);
                productRepository.save(product);
                return true;
            } catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }

}
