package com.vn.bidu.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class CategoryResponse implements Serializable {
    private int id;
    private String nameCategory;
    private String thumbnail;
    private List<ProductResponse> listProduct;
}
