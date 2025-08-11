package com.vn.bidu.converter;

import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShopConverter {
    @Autowired
    private ModelMapper mapper;

    public ShopResponse toShopDTO(Shop shop) {
        return mapper.map(shop, ShopResponse.class);
    }
}
