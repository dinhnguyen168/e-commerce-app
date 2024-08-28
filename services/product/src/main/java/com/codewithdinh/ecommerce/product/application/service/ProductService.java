package com.codewithdinh.ecommerce.product.application.service;

import com.codewithdinh.ecommerce.product.application.dto.ProductPurchaseRequest;
import com.codewithdinh.ecommerce.product.application.dto.ProductPurchaseResponse;
import com.codewithdinh.ecommerce.product.application.dto.ProductRequest;
import com.codewithdinh.ecommerce.product.application.dto.ProductResponse;
import com.codewithdinh.ecommerce.product.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product createProduct(ProductRequest request);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests);

    ProductResponse findProductById(Integer productId);

    List<ProductResponse> findAllProducts();
}
