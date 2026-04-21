package com.example.demo.repositaries;

import com.example.demo.controllers.ProductController;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategory extends JpaRepository<Product,Long> {
    //update is also done using save()
    //if the product you try to save has an ID
    //JPA will see if a product with that ID exists
    //If NO -> iNSERT
    //iF YES ->UPdate

    @Override
    Product save(Product p);

    @Override
    void delete(Product entity);
}
