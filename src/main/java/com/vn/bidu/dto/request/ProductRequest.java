package com.vn.bidu.dto.request;

import com.vn.bidu.dto.response.DiscountBiduResponse;
import com.vn.bidu.dto.response.VariantResponse;
import com.vn.bidu.entity.Variant;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String nameProduct;
    private int price;
    private int percent;
    private int soldQuantity;
    private String descriptionProduct;
    private String material;
    private String origin;
    private String style;
    private String vignette;
    private String collar;
    private String season;
    private String bodyShape;
    private String gender;
    private String brand;
    private Set<VariantRequest> variants;
    private List<Integer> discountIds;
}
