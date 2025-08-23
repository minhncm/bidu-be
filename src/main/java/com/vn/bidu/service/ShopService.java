package com.vn.bidu.service;

import com.vn.bidu.dto.request.ShopRequest;
import com.vn.bidu.dto.response.ShopResponse;

import java.util.List;

public interface ShopService {
    List<ShopResponse> getAllShop();
    ShopResponse getShopById(int id);
    ShopResponse addShop(ShopRequest shopRequest);
    void deleteShop(int id);
}
