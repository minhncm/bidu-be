package com.vn.bidu.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopRequest {

    private String nameShop;
    private String avatar;
    private String thumbnail;
    private String email;
    private String phoneNumber;
    private String location;

}
