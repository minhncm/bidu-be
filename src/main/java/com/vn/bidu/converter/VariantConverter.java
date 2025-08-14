package com.vn.bidu.converter;

import com.vn.bidu.dto.response.VariantResponse;
import com.vn.bidu.entity.Variant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VariantConverter {
    @Autowired
    private ModelMapper mapper;

    public VariantResponse toVariantResponse(Variant variant) {
        return mapper.map(variant, VariantResponse.class);
    }

}
