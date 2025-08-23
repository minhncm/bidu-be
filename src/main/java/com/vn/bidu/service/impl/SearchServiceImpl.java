package com.vn.bidu.service.impl;

import com.vn.bidu.converter.ProductConverter;
import com.vn.bidu.converter.ShopConverter;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.dto.response.SearchResponse;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Product;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.repository.ProductRepository;
import com.vn.bidu.repository.ShopRepository;
import com.vn.bidu.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final ShopConverter shopConverter;
    private final ProductConverter productConverter;

    @Override
    public SearchResponse search(Map<String, Object> params) {
        return null;
    }
}
