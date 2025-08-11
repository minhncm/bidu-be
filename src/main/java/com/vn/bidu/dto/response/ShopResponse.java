package com.vn.bidu.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopResponse {
    private int id;
    private String nameShop;
    private String avatar;
    private String thumbnail;
    private String email;
    private String phoneNumber;
    private int followingShop;
    private int followerShop;
    private String location;
}
