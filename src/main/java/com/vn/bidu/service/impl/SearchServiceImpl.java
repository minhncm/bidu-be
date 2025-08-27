package com.vn.bidu.service.impl;

import com.vn.bidu.converter.ProductConverter;
import com.vn.bidu.converter.ProductFilterConverter;
import com.vn.bidu.converter.ShopConverter;
import com.vn.bidu.converter.UserConverter;
import com.vn.bidu.dto.request.ProductFilterRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.dto.response.SearchResponse;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.dto.response.UserResponse;
import com.vn.bidu.entity.Product;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.entity.User;
import com.vn.bidu.repository.ProductRepositoryCustom;
import com.vn.bidu.repository.ShopRepository;
import com.vn.bidu.repository.UserRepository;
import com.vn.bidu.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    private final ProductFilterConverter productFilterConverter;
    private final ProductRepositoryCustom productRepositoryCustom;
    private final ProductConverter productConverter;
    private final UserConverter userConverter;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;
    private final ShopConverter shopConverter;

    @Override
    public SearchResponse search(Map<String, Object> params) {
        ProductFilterRequest request = productFilterConverter.toProductFilterRequest(params);

        List<Product> products = productRepositoryCustom.filterMultiCriteria(request);
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            ProductResponse productResponse = productConverter.toProductResponse(product);
            productResponses.add(productResponse);
        }

        List<User> users = userRepository.findTop3ByFullNameContaining(request.getKeyword());
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = userConverter.toUserResponse(user);
            userResponses.add(userResponse);
        }

        List<Shop> shops = shopRepository.findTop3ByNameShopContaining(request.getKeyword());
        List<ShopResponse> shopResponses = new ArrayList<>();
        for (Shop shop : shops) {
            ShopResponse shopResponse = shopConverter.toShopResponse(shop);
            shopResponses.add(shopResponse);
        }

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setProductResponses(productResponses);
        searchResponse.setUsers(userResponses);
        searchResponse.setShops(shopResponses);
        return searchResponse;
    }
}
