package com.vn.bidu.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseData<T> implements Serializable {
    private int status = 200;
    private String message;
    private T data;

    public ResponseData(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
