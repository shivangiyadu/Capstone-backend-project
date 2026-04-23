package com.example.demo.services;

import com.example.demo.models.Product;
import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product partialUpdateProduct(Long productId, Product product); // ✅ only declaration
}