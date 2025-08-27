package com.vn.bidu.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductResponse implements Serializable  {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int id;
    private String nameProduct;
    private List<String> thumbnail;
    private String price;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String discountPrice;
    private String percent;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
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
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int rating;
    private ShopResponse shop;
    private List<DiscountBiduResponse> discounts;
    private List<VariantResponse> variants;
}
