package com.vn.bidu.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductFilterRequest {
    private String keyword;
    private List<String> city;
    private List<String> size;
    private Long priceFrom;
    private Long priceTo;
    private List<String> gender;
    private List<String> style;
}
