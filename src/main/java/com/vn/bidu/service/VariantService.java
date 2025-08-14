package com.vn.bidu.service;

import com.vn.bidu.dto.response.VariantResponse;

import java.util.List;

public interface VariantService {
    List<VariantResponse> getAllVariant();
    VariantResponse getVariantById(int id);

}
