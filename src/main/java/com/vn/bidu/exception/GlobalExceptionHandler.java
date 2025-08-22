package com.vn.bidu.exception;

import com.vn.bidu.dto.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.*;

import java.util.Date;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setPath(request.getDescription(false).replace("uri=", ""));
        errorResponse.setStatus(INTERNAL_SERVER_ERROR.value());
        errorResponse.setError(NOT_FOUND.getReasonPhrase());
        errorResponse.setMessage(e.getMessage());

        return errorResponse;
    }

    @ExceptionHandler(ShopException.class)
    public ErrorResponse handleShopException(ShopException e, WebRequest request) {
        return buildErrorResponse(e.getErrorCode(), request);
    }

    @ExceptionHandler(ProductException.class)
    public ErrorResponse handleProductException(ProductException e, WebRequest request) {
        return buildErrorResponse(e.getErrorCode(), request);
    }

    private ErrorResponse buildErrorResponse(ErrorCode errorCode, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setPath(request.getDescription(false).replace("uri=", ""));
        errorResponse.setStatus(errorCode.getStatus().value());
        errorResponse.setError(errorCode.getStatus().getReasonPhrase());
        errorResponse.setMessage(errorCode.getMessage());
        return errorResponse;
    }

}
