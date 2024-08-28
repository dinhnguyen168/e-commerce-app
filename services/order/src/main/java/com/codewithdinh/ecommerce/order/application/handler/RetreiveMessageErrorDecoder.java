package com.codewithdinh.ecommerce.order.application.handler;

import com.codewithdinh.ecommerce.order.application.dto.ExceptionMessage;
import com.codewithdinh.ecommerce.order.domain.exception.BusinessException;
import com.codewithdinh.ecommerce.order.domain.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = null;
        try (InputStream bodyIs = response.body()
                .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ExceptionMessage.class);
        } catch (IOException e) {
            return new RuntimeException(e.getMessage());
        }
        return switch (response.status()) {
            case 400 -> new BusinessException(message.errorMessage());
            case 404 -> new ResourceNotFoundException(message.errorMessage());
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
