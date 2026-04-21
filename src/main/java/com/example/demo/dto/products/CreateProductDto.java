package com.example.demo.dto.products;
import com.example.demo.models.Category;
import lombok.Getter;
import lombok.Setter;
import com.example.demo.models.Product;
@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;


    public static CreateProductDto fromProduct(Product product) {
        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());

        return responseDto;
    }
    public Product toProduct()
    {
        Product product=new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);

        Category category=new Category();

        category.setName(this.category.getName());
        product.setCategory(category);
        return product;

    }
}