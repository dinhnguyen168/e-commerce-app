package com.codewithdinh.ecommerce.order.application.handler;


import com.codewithdinh.ecommerce.order.application.dto.ErrorResponse;
import com.codewithdinh.ecommerce.order.application.dto.ExceptionMessageResponse;
import com.codewithdinh.ecommerce.order.domain.exception.BusinessException;
import com.codewithdinh.ecommerce.order.domain.exception.OrderNotFoundException;
import com.codewithdinh.ecommerce.order.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {OrderNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessageResponse handleCustomerNotFoundException(OrderNotFoundException e) {
        return new ExceptionMessageResponse(e.getMessage());
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessageResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ExceptionMessageResponse(e.getMessage());
    }

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionMessageResponse handleBusinessException(BusinessException e) {
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
