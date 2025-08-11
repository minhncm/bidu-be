package com.vn.bidu.controller;

import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @GetMapping
    public List<ShopResponse> getAllShop() {
        return shopService.getAllShop();
    }

    @GetMapping("/{id}")
    public ShopResponse getShopById(@PathVariable int id) {
        return shopService.getShopById(id);
    }
}
