package com.example.demo.dto.products;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
   private long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;

    public Product toProduct()
    {
        Product product=new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        product.setCategory(this.category);
        return product;

    }

}


//DTOs are the shape of data that comes from the client.  DtOs are basically the form that customer fills at reception