package com.test.back.service;


import com.test.back.model.Product;
import com.test.back.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            if (updatedProduct.getCode() != null) {
                product.setCode(updatedProduct.getCode());
            }
            if (updatedProduct.getName() != null) {
                product.setName(updatedProduct.getName());
            }
            if (updatedProduct.getDescription() != null) {
                product.setDescription(updatedProduct.getDescription());
            }
            if (updatedProduct.getImage() != null) {
                product.setImage(updatedProduct.getImage());
            }
            if (updatedProduct.getCategory() != null) {
                product.setCategory(updatedProduct.getCategory());
            }
            if (updatedProduct.getPrice() != null) {
                product.setPrice(updatedProduct.getPrice());
            }
            if (updatedProduct.getQuantity() != null) {
                product.setQuantity(updatedProduct.getQuantity());
            }
            if (updatedProduct.getInternalReference() != null) {
                product.setInternalReference(updatedProduct.getInternalReference());
            }
            if (updatedProduct.getShellId() != null) {
                product.setShellId(updatedProduct.getShellId());
            }
            if (updatedProduct.getInventoryStatus() != null) {
                product.setInventoryStatus(updatedProduct.getInventoryStatus());
            }
            if (updatedProduct.getRating() != null) {
                product.setRating(updatedProduct.getRating());
            }

            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
