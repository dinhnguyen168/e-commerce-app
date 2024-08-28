package com.codewithdinh.ecommerce.product.application.handler;


import com.codewithdinh.ecommerce.product.application.dto.ErrorResponse;
import com.codewithdinh.ecommerce.product.application.dto.ExceptionMessageResponse;
import com.codewithdinh.ecommerce.product.domain.exception.ProductNotFoundException;
import com.codewithdinh.ecommerce.product.domain.exception.ProductPurchaseException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessageResponse handleCustomerNotFoundException(ProductNotFoundException e) {
        return new ExceptionMessageResponse(e.getMessage());
    }

    @ExceptionHandler(ProductPurchaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionMessageResponse handleCustomerNotFoundException(ProductPurchaseException e) {
        return new ExceptionMessageResponse(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors()
                .forEach((error) -> {
                    var fieldError = (FieldError) error;
                    String field = fieldError.getField();
                    var errorMessage = fieldError.getDefaultMessage();
                    errors.put(field, errorMessage);
                });
        return new ErrorResponse(errors);
    }
}
