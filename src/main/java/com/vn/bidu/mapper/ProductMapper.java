package com.vn.bidu.mapper;

import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toProductEntity(ProductRequest request, @MappingTarget Product product);
}
