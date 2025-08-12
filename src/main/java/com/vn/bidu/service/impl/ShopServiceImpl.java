package com.vn.bidu.service.impl;

import com.vn.bidu.converter.ShopConverter;
import com.vn.bidu.dto.request.ShopRequest;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.repository.ShopRepository;
import com.vn.bidu.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

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

    @Override
    public boolean addShop(ShopRequest shopRequest) {
        try {
            Shop shop = Shop.builder()
                    .nameShop(shopRequest.getNameShop())
                    .email(shopRequest.getEmail())
                    .phoneNumber(shopRequest.getPhoneNumber())
                    .avatar(shopRequest.getAvatar())
                    .thumbnail(shopRequest.getThumbnail())
                    .location(shopRequest.getLocation()).build();
            shopRepository.save(shop);
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Add shop failure");
        }

    }

    @Override
    public void deleteShop(int id) {

       Optional<Shop> shop = shopRepository.findById(id);
       if(shop.isPresent()){
           shopRepository.deleteById(id);
       }
       else{
           throw new RuntimeException("Shop not found");
       }

    }
}
