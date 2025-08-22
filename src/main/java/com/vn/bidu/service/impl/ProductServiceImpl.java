package com.vn.bidu.service.impl;

import com.vn.bidu.constant.CloudPath;
import com.vn.bidu.converter.ProductConverter;
import com.vn.bidu.converter.VariantConverter;
import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.dto.request.VariantRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.entity.DiscountBidu;
import com.vn.bidu.entity.Product;
import com.vn.bidu.entity.Variant;

import com.vn.bidu.exception.DiscountException;
import com.vn.bidu.exception.ErrorCode;
import com.vn.bidu.exception.ProductException;
import com.vn.bidu.exception.VariantException;
import com.vn.bidu.repository.DiscountRepository;
import com.vn.bidu.repository.ProductRepository;
import com.vn.bidu.repository.VariantRepository;
import com.vn.bidu.service.CloudinaryService;
import com.vn.bidu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final DiscountRepository discountRepository;
    private final VariantRepository variantRepository;
    private final CloudinaryService cloudinaryService;

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
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductException(ErrorCode.PRODUCT_NOT_FOUND));
        return productConverter.toProductResponse(product);
    }

    @Override
    public boolean updateProduct(int id, ProductRequest productRequest, List<MultipartFile> images) {
        try{
            Product product = productRepository.findById(id).orElseThrow(
                    () -> new ProductException(ErrorCode.PRODUCT_NOT_FOUND));

            Product newProduct = productConverter.toProductEntity(productRequest, product);
            newProduct.setThumbnail(cloudinaryService.getUrlListFile(images, CloudPath.PRODUCT));

            if(productRequest.getDiscountIds() != null && !productRequest.getDiscountIds().isEmpty()  ){
                Set<DiscountBidu> discountBiduSet = new HashSet<>();
                for(int idDiscount : productRequest.getDiscountIds()){
                    DiscountBidu discountBidu = discountRepository.findById(idDiscount).orElseThrow(
                            () -> new DiscountException(ErrorCode.DISCOUNT_NOT_FOUND)
                    );
                    discountBiduSet.add(discountBidu);
                }
                newProduct.getDiscounts().clear();
                newProduct.getDiscounts().addAll(discountBiduSet);
            }
            if(productRequest.getVariants() != null && !productRequest.getVariants().isEmpty()){
               Set<Variant> variantSet = new HashSet<>();
               for(VariantRequest variantRequest : productRequest.getVariants() ){
                   Variant variant ;
                   if(variantRequest.getId() == null ){
                       variant = variantConverter.toVariantEntity(variantRequest);
                       variant.setProduct(newProduct);
                   }
                   else{
                       variant = variantRepository.findById(variantRequest.getId()).orElseThrow(
                               () -> new VariantException(ErrorCode.VARIANT_NOT_FOUND)
                       );
                       variantConverter.toVariantEntity(variantRequest,variant);
                   }
                   variantSet.add(variant);

               }
               newProduct.getVariants().clear();
               newProduct.getVariants().addAll(variantSet);
            }
            productRepository.save(newProduct);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public void deleteProduct(int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
        }else{
            throw new ProductException(ErrorCode.PRODUCT_NOT_FOUND);
        }
    }

    @Override
    public boolean createProduct(ProductRequest productRequest, List<MultipartFile> images) {
        try {
            Product product = productConverter.toProductEntity(productRequest, new Product());
            product.setThumbnail(cloudinaryService.getUrlListFile(images, CloudPath.PRODUCT));

            if (productRequest.getDiscountIds() != null && !productRequest.getDiscountIds().isEmpty()) {
                Set<DiscountBidu> discountBidus = new HashSet<>();
                for (int discountId : productRequest.getDiscountIds()) {
                    DiscountBidu discountBidu = discountRepository.findById(discountId)
                            .orElseThrow(() -> new DiscountException(ErrorCode.DISCOUNT_NOT_FOUND));
                    discountBidus.add(discountBidu);
                }
                product.setDiscounts(discountBidus);
            }

            if (productRequest.getVariants() != null && !productRequest.getVariants().isEmpty()) {
                Set<Variant> variants = new HashSet<>();
                for (VariantRequest variantRequest : productRequest.getVariants()) {
                    Variant variant = variantConverter.toVariantEntity(variantRequest);
                    variant.setProduct(product);
                    variants.add(variant);
                }
                product.setVariants(variants);
            }

            productRepository.save(product);
            return true;
            } catch(Exception e){
                throw new ProductException(ErrorCode.PRODUCT_CREATE_FAILURE);
            }
        }

}
