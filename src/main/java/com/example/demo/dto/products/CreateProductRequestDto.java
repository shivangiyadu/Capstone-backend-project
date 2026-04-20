package com.example.demo.dto.products;

import com.example.demo.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;

    public Product toProduct()
    {
        Product product=new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        product.setCategoryName(this.categoryName);
        return product;

    }

}


//DTOs are the shape of data that comes from the client.  DtOs are basically the form that customer fills at reception