package com.vn.bidu.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private int id;
    private String nameCategory;
    private String thumbnail;

}
