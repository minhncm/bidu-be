package com.vn.bidu.service.impl;

import com.vn.bidu.converter.ShopConverter;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.repository.ShopRepository;
import com.vn.bidu.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopConverter shopConverter;
    @Override
    public List<ShopResponse> getAllShop() {
        List<Shop> shops = shopRepository.findAll();
        List<ShopResponse> shopResponses = new ArrayList<>();
        for(Shop shop : shops) {
            ShopResponse shopResponse = shopConverter.toShopDTO(shop);
            shopResponses.add(shopResponse);
        }
        return shopResponses;
    }

    @Override
    public ShopResponse getShopById(int id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
        return shopConverter.toShopDTO(shop);
    }
}
