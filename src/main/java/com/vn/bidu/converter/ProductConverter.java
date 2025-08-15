package com.vn.bidu.converter;

import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Product;
import com.vn.bidu.utils.ListUtils;
import com.vn.bidu.utils.NumberFormatUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper mapper;


    public Product toProductEntity(ProductRequest productRequest, Product product){

        mapper.map(productRequest, product);
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = mapper.map(product, ProductResponse.class);
        productResponse.setPrice(NumberFormatUtils.formatVNCurrency(product.getPrice()));
        productResponse.setDiscountPrice(calculateAmount(product.getPrice(), product.getPercent()));
        productResponse.setPercent(NumberFormatUtils.formatPercentage(product.getPercent()));
        productResponse.setThumbnail(ListUtils.splitString(product.getThumbnail(),","));
        return productResponse;
    }
    private String calculateAmount(int price, int percent){
        return NumberFormatUtils.formatVNCurrency((100-percent)/100.0*price);
    }
}
