package com.vn.bidu.service.impl;

import com.vn.bidu.converter.ProductConverter;
import com.vn.bidu.converter.VariantConverter;
import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.dto.request.VariantRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.entity.DiscountBidu;
import com.vn.bidu.entity.Product;
import com.vn.bidu.entity.Variant;
import com.vn.bidu.mapper.ProductMapper;
import com.vn.bidu.mapper.VariantMapper;
import com.vn.bidu.repository.DiscountRepository;
import com.vn.bidu.repository.ProductRepository;
import com.vn.bidu.repository.VariantRepository;
import com.vn.bidu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final DiscountRepository discountRepository;
    private final ProductMapper productMapper;
    private final VariantRepository variantRepository;
    private final VariantMapper variantMapper;

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
            Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
            productMapper.toProductEntity(productRequest, product);

            if(productRequest.getDiscountIds() != null) {
                product.getDiscounts().clear();
                List<DiscountBidu> discounts = discountRepository.findAllById(productRequest.getDiscountIds());
                product.getDiscounts().addAll(discounts);
            }

            Set<Variant> variants = new HashSet<>();
            if(productRequest.getVariants() != null) {
                for (VariantRequest variantRequest : productRequest.getVariants()) {
                    Variant variant;
                    if (variantRequest.getId() != null) {
                        variant = variantRepository.findById(variantRequest.getId())
                                .orElseThrow(() -> new RuntimeException("Variant not found"));
                    } else {
                        variant = new Variant();
                        variant.setProduct(product);
                    }
                    variantMapper.toVariantEntity(variantRequest, variant);
                    variants.add(variant);
                }
                product.getVariants().clear();
                product.getVariants().addAll(variants);
            }
            productRepository.save(product);
            return true;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
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

    @Override
    public boolean createProduct(ProductRequest productRequest) {
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
