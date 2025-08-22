package com.vn.bidu.exception;

import lombok.Getter;

@Getter
public class DiscountException extends RuntimeException{
    private ErrorCode errorCode;

    public DiscountException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
