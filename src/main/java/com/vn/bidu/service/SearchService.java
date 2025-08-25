package com.vn.bidu.service;

import com.vn.bidu.dto.response.SearchResponse;

import java.util.Map;

public interface SearchService {
    SearchResponse search(Map<String, Object> params);
}
