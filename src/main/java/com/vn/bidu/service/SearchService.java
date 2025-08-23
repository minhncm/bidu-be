package com.vn.bidu.service;

import com.vn.bidu.dto.response.SearchResponse;

public interface SearchService {
    SearchResponse search(String name, String type);
}
