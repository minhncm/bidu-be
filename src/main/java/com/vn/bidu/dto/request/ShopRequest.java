package com.vn.bidu.dto.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopRequest {
    private String nameShop;
    private String avatar;
    private String thumbnail;
    private String email;
    private String phoneNumber;
    private String location;

}
