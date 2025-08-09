package com.vn.bidu.converter;

import com.vn.bidu.dto.ShopDTO;
import com.vn.bidu.entity.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShopConverter {
    @Autowired
    private ModelMapper mapper;

    public ShopDTO toShopDTO(Shop shop) {
        return mapper.map(shop, ShopDTO.class);
    }
}
