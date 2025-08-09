package com.vn.bidu.service.impl;

import com.vn.bidu.converter.ShopConverter;
import com.vn.bidu.dto.ShopDTO;
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
    public List<ShopDTO> getAllShop() {
        List<Shop> shops = shopRepository.findAll();
        List<ShopDTO> shopDTOs = new ArrayList<>();
        for(Shop shop : shops) {
            ShopDTO shopDTO = shopConverter.toShopDTO(shop);
            shopDTOs.add(shopDTO);
        }
        return shopDTOs;
    }
}
