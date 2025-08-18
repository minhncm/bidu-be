package com.vn.bidu.mapper;

import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {VariantMapper.class})
public interface ProductMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toProductEntity(ProductRequest request, @MappingTarget Product product);
}
