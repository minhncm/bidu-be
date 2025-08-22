package com.vn.bidu.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
public class ShopException extends RuntimeException{
    private ErrorCode errorCode;
    public ShopException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
