package com.vn.bidu.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DiscountBiduResponse implements Serializable {
    private int id;
    private int price;
    private String image;
    private String description;


}
