package com.vn.bidu.controller;

import com.cloudinary.api.ApiResponse;
import com.vn.bidu.constant.CloudPath;
import com.vn.bidu.dto.request.ShopRequest;
import com.vn.bidu.dto.response.PaymentMethodResponse;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.service.CloudinaryService;
import com.vn.bidu.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping
    public ResponseData<List<ShopResponse>> getAllShop() {
        return new ResponseData<>(HttpStatus.OK.value(),"Shop retrieved successfully", shopService.getAllShop());
    }

    @GetMapping("/{id}")
    public ResponseData<ShopResponse> getShopById(@PathVariable int id) {
        return new ResponseData<>(HttpStatus.OK.value(),"Shop retrieved successfully", shopService.getShopById(id));
    }

    @PostMapping
    public ResponseData<ShopResponse> addShop(@RequestParam("name_shop") String nameShop,
                                              @RequestParam("avatar") MultipartFile avatar,
                                              @RequestParam("thumbnail") MultipartFile thumbnail,
                                              @RequestParam("email") String email,
                                              @RequestParam("phone_number") String phoneNumber,
                                              @RequestParam("location") String location){
        ShopRequest shopRequest = ShopRequest.builder()
                .nameShop(nameShop)
                .avatar(avatar)
                .thumbnail(thumbnail)
                .email(email)
                .phoneNumber(phoneNumber)
                .location(location).build();

        ShopResponse shopResponse = shopService.addShop(shopRequest);
        return new ResponseData<>(HttpStatus.CREATED.value(), "Shop added successfully", shopResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseData<Void> deleteShop( @PathVariable int id){
        shopService.deleteShop(id);
        return new ResponseData<>(HttpStatus.OK.value(), "Shop deleted successfully");
    }

}
