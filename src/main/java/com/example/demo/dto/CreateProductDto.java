package com.example.demo.dto;
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
    private String categoryName;

    public static CreateProductDto fromProduct(Product product) {
        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());

        return responseDto;
    }
}