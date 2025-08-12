package com.vn.bidu.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private int id;
    private String nameProduct;
    private String thumbnail;
    private int price;
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
}
