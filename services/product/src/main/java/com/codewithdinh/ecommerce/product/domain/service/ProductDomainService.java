package com.codewithdinh.ecommerce.product.domain.service;

import com.codewithdinh.ecommerce.product.domain.model.Product;
import org.springframework.stereotype.Service;


public interface ProductDomainService {
    Product purchaseProduct(Product product, double numberOfPurchasedProduct);
}
