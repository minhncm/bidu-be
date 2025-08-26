package com.vn.bidu.converter;

import com.vn.bidu.dto.request.ProductFilterRequest;
import com.vn.bidu.utils.ListUtils;
import com.vn.bidu.utils.MapUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProductFilterConverter {
    public ProductFilterRequest toProductFilterRequest(Map<String, Object> params) {

        return ProductFilterRequest.builder()
                .keyword(MapUtils.getObject(params, "keyword", String.class))
                .city(ListUtils.splitString(MapUtils.getObject(params, "city", String.class), ","))
                .size(ListUtils.splitString(MapUtils.getObject(params, "size", String.class), ","))
                .priceFrom(MapUtils.getObject(params, "priceFrom", Long.class))
                .priceTo(MapUtils.getObject(params, "priceTo", Long.class))
                .gender(MapUtils.getObject(params, "gender", String.class))
                .style(ListUtils.splitString(MapUtils.getObject(params, "style", String.class), ","))
                .build();
    }
}
