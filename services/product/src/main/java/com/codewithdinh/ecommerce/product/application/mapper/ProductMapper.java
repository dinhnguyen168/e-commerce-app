package com.codewithdinh.ecommerce.product.application.mapper;

import com.codewithdinh.ecommerce.product.application.dto.ProductPurchaseResponse;
import com.codewithdinh.ecommerce.product.application.dto.ProductRequest;
import com.codewithdinh.ecommerce.product.application.dto.ProductResponse;
import com.codewithdinh.ecommerce.product.domain.model.Category;
import com.codewithdinh.ecommerce.product.domain.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .category(Category.builder().id(request.categoryId()).build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .build();
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product) {
        return ProductPurchaseResponse.builder()
                .productId(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getAvailableQuantity())
                .build();
    }
}
