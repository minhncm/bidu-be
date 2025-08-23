package com.vn.bidu.service.impl;

import com.vn.bidu.converter.VariantConverter;
import com.vn.bidu.dto.response.VariantResponse;
import com.vn.bidu.entity.Variant;
import com.vn.bidu.exception.ErrorCode;
import com.vn.bidu.exception.VariantException;
import com.vn.bidu.repository.VariantRepository;
import com.vn.bidu.service.VariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class VariantServiceImpl implements VariantService {

    private final VariantRepository variantRepository;

    @Autowired
    private VariantConverter variantConverter;

    @Override
    public List<VariantResponse> getAllVariant() {

        List<Variant> variants = variantRepository.findAll();
        List<VariantResponse> variantResponseList = new ArrayList<>();

        for(Variant variant : variants){
            VariantResponse variantResponse = variantConverter.toVariantResponse(variant);
            variantResponseList.add(variantResponse);
        }
        return variantResponseList;
    }

    @Override
    public VariantResponse getVariantById(int id) {
        Variant variant = variantRepository.findById(id).orElseThrow(() -> new VariantException(ErrorCode.VARIANT_NOT_FOUND));
        return variantConverter.toVariantResponse(variant);
    }
}
