package com.codewithdinh.ecommerce.product.application.service;

import com.codewithdinh.ecommerce.product.application.dto.ProductPurchaseRequest;
import com.codewithdinh.ecommerce.product.application.dto.ProductPurchaseResponse;
import com.codewithdinh.ecommerce.product.application.dto.ProductRequest;
import com.codewithdinh.ecommerce.product.application.dto.ProductResponse;
import com.codewithdinh.ecommerce.product.application.mapper.ProductMapper;
import com.codewithdinh.ecommerce.product.domain.exception.ProductPurchaseException;
import com.codewithdinh.ecommerce.product.domain.model.Product;
import com.codewithdinh.ecommerce.product.domain.repository.ProductRepository;
import com.codewithdinh.ecommerce.product.domain.service.ProductDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ProductDomainService productDomainService;

    @Override
    public Product createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        return repository.saveProductInDatabase(product);
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests) {
        var productIds = requests.stream().map(ProductPurchaseRequest::productId).toList();
        var storedProducts = repository.findAllProductsByIds(productIds);
        if (productIds.size() != storedProducts.size()) {
           throw new ProductPurchaseException("One or more products is not available");
        }
        var storedRequests = requests.stream().sorted(Comparator.comparing(ProductPurchaseRequest::productId)).toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            Product storedProduct = storedProducts.get(i);
            ProductPurchaseRequest productRequest = storedRequests.get(i);
            double numberOfPurchasedProduct = productRequest.quantity();
            Product purchasedProduct = productDomainService.purchaseProduct(storedProduct, numberOfPurchasedProduct);
            purchasedProducts.add(mapper.toProductPurchaseResponse(purchasedProduct));
        }
        return purchasedProducts;
    }

    @Override
    public ProductResponse findProductById(Integer productId) {
        Product product = repository.findProductById(productId);
        return mapper.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        List<Product> allProducts = repository.findAllProducts();
        return allProducts.stream().map(mapper::toProductResponse).toList();
    }
}
