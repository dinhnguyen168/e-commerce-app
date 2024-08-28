package com.codewithdinh.ecommerce.product.infrastructure.web;

import com.codewithdinh.ecommerce.product.application.dto.ProductPurchaseRequest;
import com.codewithdinh.ecommerce.product.application.service.ProductService;
import com.codewithdinh.ecommerce.product.application.dto.ProductPurchaseResponse;
import com.codewithdinh.ecommerce.product.application.dto.ProductRequest;
import com.codewithdinh.ecommerce.product.application.dto.ProductResponse;
import com.codewithdinh.ecommerce.product.domain.model.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@RequestBody @Valid ProductRequest request) {
        return service.createProduct(request);
    }

    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductPurchaseResponse> purchaseProducts(@RequestBody @Valid List<ProductPurchaseRequest> requests) {
        return service.purchaseProducts(requests);
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable Integer productId) {
        return service.findProductById(productId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProducts() {
        return service.findAllProducts();
    }
}
