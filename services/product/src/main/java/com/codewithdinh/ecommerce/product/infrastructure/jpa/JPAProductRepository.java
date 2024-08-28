package com.codewithdinh.ecommerce.product.infrastructure.jpa;

import com.codewithdinh.ecommerce.product.domain.exception.ProductNotFoundException;
import com.codewithdinh.ecommerce.product.domain.model.Product;
import com.codewithdinh.ecommerce.product.domain.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.lang.String.format;

@Repository
public interface JPAProductRepository extends JpaRepository<Product, Integer>, ProductRepository {
    default Product saveProductInDatabase(Product product) {
        return save(product);
    }

    default Product findProductById(Integer productId) {
        return findById(productId).orElseThrow(
                () -> new ProductNotFoundException(format("Product with id %s not found", productId)));
    }

    default List<Product> findAllProducts() {
        return findAll();
    }

    default List<Product> findAllProductsByIds(List<Integer> productIds) {
        return productIds.stream().map(this::findProductById).toList();
    }

}
