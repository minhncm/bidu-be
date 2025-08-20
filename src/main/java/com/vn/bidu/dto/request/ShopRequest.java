package com.vn.bidu.dto.request;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopRequest {
    private String nameShop;
    private MultipartFile avatar;
    private MultipartFile thumbnail;
    private String email;
    private String phoneNumber;
    private String location;

}
