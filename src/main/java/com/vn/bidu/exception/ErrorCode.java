package com.vn.bidu.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    SHOP_NOT_FOUND(NOT_FOUND, "Shop not found"),
    SHOP_ADDED_FAILURE(BAD_REQUEST, "Shop added failure"),

    PRODUCT_NOT_FOUND(NOT_FOUND, "Product not found"),
    PRODUCT_CREATE_FAILURE(BAD_REQUEST, "Product create failure"),

    DISCOUNT_NOT_FOUND(NOT_FOUND, "Discount not found"),

    VARIANT_NOT_FOUND(NOT_FOUND, "Variant not found");

    private HttpStatus status;
    private String message;
}
