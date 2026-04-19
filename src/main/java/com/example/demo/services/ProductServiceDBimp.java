package com.example.demo.services;

import com.example.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBimp implements ProductService {

    @Override
    public Product createProduct(Product product)
    {
        return null;
    }

    @Override
    public List<Product> getAllProducts()
    {
  return List.of();
    }
}