package org.example.ordermangementsystem.service;

import org.example.ordermangementsystem.model.Product;
import org.example.ordermangementsystem.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product existingProduct = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setProductName(productDetails.getProductName());
        return productRepo.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
