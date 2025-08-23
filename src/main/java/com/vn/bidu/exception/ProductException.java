package com.vn.bidu.exception;

import lombok.Getter;

@Getter

public class ProductException extends RuntimeException{
    private ErrorCode errorCode;

    public ProductException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
