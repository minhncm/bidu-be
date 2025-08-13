package com.vn.bidu.converter;

import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.dto.response.SizeColorResponse;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.entity.SizeColor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SizeColorConverter {
    @Autowired
    private ModelMapper mapper;

    public SizeColorResponse toSizeColorResponse(SizeColor sizeColor) {
        return mapper.map(sizeColor, SizeColorResponse.class);
    }

}
