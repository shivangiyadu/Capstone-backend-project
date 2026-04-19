package com.example.demo.services;

import com.example.demo.models.Product;

import java.util.List;

public interface ProductService {


    Product createProduct(Product product);
    List<Product> getAllProducts();
}



//controller talks to product service not to db or API directly