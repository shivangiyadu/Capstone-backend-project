package com.example.demo.services;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositaries.CategoryRepositary;
import com.example.demo.repositaries.ProductRepositary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDBImp implements ProductService {
    private ProductRepositary productRepositary;
    private CategoryRepositary categoryRepositary;

    public ProductServiceDBImp(ProductRepositary productRepositary,CategoryRepositary categoryRepositary)

    {
        this.productRepositary=productRepositary;
        this.categoryRepositary=categoryRepositary;

    }

    @Override
    public Product createProduct(Product product) {

        product.setId(null);
        String categoryName=product.getCategory().getName();

     Optional<Category> category=categoryRepositary.findByName(categoryName);
     Category tobePutInproduct= null;
     if(category.isEmpty())
     {
         Category toSaveCategoy=new Category();
         toSaveCategoy.setName(categoryName);
         tobePutInproduct= categoryRepositary.save(toSaveCategoy);
     }
     else {
         tobePutInproduct=category.get();
     }
        product.setCategory(tobePutInproduct);
        Product savedProduct=productRepositary.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositary.findAll();
    }

@Override
    public Product partialUpdateProduct(Long productId, Product product)
             {
        Optional<Product> productToUpdateOptional= productRepositary.findById(productId);

        if(productToUpdateOptional.isEmpty())
        {
            throw new ProductNotFoundException("Product not found");
        }
        Product productToUpdate=productToUpdateOptional.get();
        if(product.getDescription()!=null)
        {
           productToUpdate.setDescription((product.getDescription()));
        }
        if(product.getPrice()!=null)
        {
            productToUpdate.setPrice(product.getPrice());
        }
        if(product.getTitle()!=null)
        {
            productToUpdate.setTitle(product.getTitle());
        }
        if(product.getCategory()!=null)
        {
            String categoryName=product.getCategory().getName();

            Optional<Category> category=categoryRepositary.findByName(categoryName);
            Category tobePutInproduct= null;
            if(category.isEmpty())
            {
                Category toSaveCategoy=new Category();
                toSaveCategoy.setName(categoryName);
                tobePutInproduct= categoryRepositary.save(toSaveCategoy);
            }
            else {
                tobePutInproduct=category.get();
            }
            productToUpdate.setCategory(tobePutInproduct);
        }
        return productRepositary.save(productToUpdate);
    }
}
