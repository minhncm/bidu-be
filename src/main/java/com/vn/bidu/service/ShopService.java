package com.vn.bidu.service;

import com.vn.bidu.dto.response.ShopResponse;

import java.util.List;

public interface ShopService {
    List<ShopResponse> getAllShop();
    ShopResponse getShopById(int id);
}
