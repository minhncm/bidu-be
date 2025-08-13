package com.vn.bidu.service;

import com.vn.bidu.dto.response.SizeColorResponse;

import java.util.List;

public interface SizeColorService {
    List<SizeColorResponse> getAllSizeColor();
    SizeColorResponse getSizeColorById(int id);
}
