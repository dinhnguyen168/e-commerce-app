package com.codewithdinh.ecommerce.order.infrastructure.client;

import com.codewithdinh.ecommerce.order.application.dto.PurchaseRequest;
import com.codewithdinh.ecommerce.order.application.dto.PurchaseResponse;
import com.codewithdinh.ecommerce.order.application.handler.RetreiveMessageErrorDecoder;
import com.codewithdinh.ecommerce.order.domain.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@FeignClient(
        name = "product-service",
        url = "${application.config.product-url}",
        configuration = {RetreiveMessageErrorDecoder.class}
)
public interface ProductClient {
    @GetMapping("/purchase")
    public List<PurchaseResponse> purchaseProducts(@RequestBody List<PurchaseRequest> requestBody);
}
