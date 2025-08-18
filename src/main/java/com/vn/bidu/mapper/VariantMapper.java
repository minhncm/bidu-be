package com.vn.bidu.mapper;

import com.vn.bidu.dto.request.VariantRequest;
import com.vn.bidu.entity.Variant;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface VariantMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toVariantEntity(VariantRequest variantRequest, @MappingTarget Variant variant);
}
