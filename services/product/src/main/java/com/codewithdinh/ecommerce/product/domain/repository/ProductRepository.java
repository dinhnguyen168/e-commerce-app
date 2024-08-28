package com.codewithdinh.ecommerce.product.domain.repository;

import com.codewithdinh.ecommerce.product.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    Product saveProductInDatabase(Product product);

    Product findProductById(Integer productId);

    List<Product> findAllProducts();

    List<Product> findAllProductsByIds(List<Integer> productIds);
}
