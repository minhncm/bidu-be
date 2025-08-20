package com.vn.bidu.converter;

import com.vn.bidu.dto.request.VariantRequest;
import com.vn.bidu.dto.response.VariantResponse;
import com.vn.bidu.entity.Variant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VariantConverter {
    @Autowired
    private ModelMapper mapper;

    public Variant toVariantEntity(VariantRequest variantRequest) {
      return   mapper.map(variantRequest, Variant.class);

    }
    public void toVariantEntity(VariantRequest variantRequest,Variant variant) {
        mapper.map(variantRequest, variant);
    }

    public VariantResponse toVariantResponse(Variant variant) {
        return mapper.map(variant, VariantResponse.class);
    }

}
