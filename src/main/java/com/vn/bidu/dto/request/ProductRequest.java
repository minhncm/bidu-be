package com.vn.bidu.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    private String nameProduct;
    private String thumbnail;
    private int price;
    private int percent;
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


}
