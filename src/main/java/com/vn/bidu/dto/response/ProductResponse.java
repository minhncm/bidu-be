package com.vn.bidu.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter

public class ProductResponse implements Serializable  {

    private int id;
    private String nameProduct;
    private List<String> thumbnail;
    private String price;
    private String discountPrice;
    private String percent;
    private int soldQuantity;
    private String descriptionProduct;
    private String material;
    private String origin;
    private String style;
    private String vignette;
    private String collar;
    private String season;
    private String bodyShape;
    private String gender;
    private String brand;
    private int rating;
    private ShopResponse shop;
    private List<DiscountBiduResponse> discounts;
    private List<VariantResponse> variants;
}
