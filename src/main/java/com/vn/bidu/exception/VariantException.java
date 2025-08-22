package com.vn.bidu.exception;

import lombok.Getter;

@Getter
public class VariantException extends RuntimeException{
    private ErrorCode errorCode;

    public VariantException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
