package com.vn.bidu.converter;

import com.vn.bidu.dto.request.ShopRequest;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShopConverter {
    @Autowired
    private ModelMapper mapper;

    public Shop toShopEntity(ShopRequest shopRequest) { return mapper.map(shopRequest, Shop.class); }
    public ShopResponse toShopResponse(Shop shop) {
        return mapper.map(shop, ShopResponse.class);
    }
}
