package com.vn.bidu.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariantRequest {
    private String color;
    private String size;
    private int inventory;
}
