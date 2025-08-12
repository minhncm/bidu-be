package com.vn.bidu.controller;

import com.vn.bidu.dto.request.ShopRequest;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;
    @GetMapping
    public List<ShopResponse> getAllShop() {
        return shopService.getAllShop();
    }

    @GetMapping("/{id}")
    public ShopResponse getShopById(@PathVariable int id) {
        return shopService.getShopById(id);
    }

    @PostMapping("/add-shop")
    public ResponseEntity<?> addShop(@RequestParam String nameShop, @RequestParam MultipartFile avatar, @RequestParam MultipartFile thumbnail, @RequestParam String email, @RequestParam String phoneNumber, @RequestParam String location){



        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseData<Boolean> deleteShop( @PathVariable int id){

        shopService.deleteShop(id);

        return new ResponseData<Boolean>(HttpStatus.OK.value(),"Delete success", true );
    }

}
