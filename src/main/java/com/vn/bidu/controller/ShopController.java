package com.vn.bidu.controller;

import com.cloudinary.api.ApiResponse;
import com.vn.bidu.constant.CloudPath;
import com.vn.bidu.dto.request.ShopRequest;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.service.CloudinaryService;
import com.vn.bidu.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;
    private final CloudinaryService cloudinaryService;
    @GetMapping
    public List<ShopResponse> getAllShop() {
        return shopService.getAllShop();
    }

    @GetMapping("/{id}")
    public ShopResponse getShopById(@PathVariable int id) {
        return shopService.getShopById(id);
    }

    @PostMapping("/add-shop")
    public ResponseData<Boolean> addShop(@RequestParam("name_shop") String nameShop,
                                     @RequestParam("avatar") MultipartFile avatar,
                                     @RequestParam("thumbnail") MultipartFile thumbnail,
                                     @RequestParam("email") String email,
                                     @RequestParam("phone_number") String phoneNumber,
                                     @RequestParam("location") String location){

        Map uploadThumbnail = cloudinaryService.uploadFile(thumbnail, CloudPath.SHOP);
        Map uploadAvatar = cloudinaryService.uploadFile(avatar, CloudPath.SHOP);
        ShopRequest shopRequest = ShopRequest.builder()
                .nameShop(nameShop)
                .avatar(uploadAvatar.get("url").toString())
                .thumbnail(uploadThumbnail.get("url").toString())
                .email(email)
                .phoneNumber(phoneNumber)
                .location(location).build();

        return new ResponseData<>(HttpStatus.OK.value(), "success", shopService.addShop(shopRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseData<Boolean> deleteShop( @PathVariable int id){
        shopService.deleteShop(id);
        return new ResponseData<>(HttpStatus.OK.value(),"Delete success", true );
    }

}
