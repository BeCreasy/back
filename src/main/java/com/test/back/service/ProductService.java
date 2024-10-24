package com.test.back.service;

import com.test.back.model.Product;
import com.test.back.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product updateProduct(Long id, Product updatedProduct);

    void deleteProduct(Long id);
}
