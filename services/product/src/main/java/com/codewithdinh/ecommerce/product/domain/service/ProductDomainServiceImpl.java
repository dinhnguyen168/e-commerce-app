package com.codewithdinh.ecommerce.product.domain.service;

import com.codewithdinh.ecommerce.product.domain.exception.ProductPurchaseException;
import com.codewithdinh.ecommerce.product.domain.model.Product;
import com.codewithdinh.ecommerce.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDomainServiceImpl implements ProductDomainService {
    private final ProductRepository repository;

    public Product purchaseProduct(Product product, double numberOfPurchasedProduct) {
        if(product.getAvailableQuantity() < numberOfPurchasedProduct) {
            throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + product.getId());
        }
        var newAvailableQuantity = product.getAvailableQuantity() - numberOfPurchasedProduct;
        product.setAvailableQuantity(newAvailableQuantity);
        return repository.saveProductInDatabase(product);
    }
}
