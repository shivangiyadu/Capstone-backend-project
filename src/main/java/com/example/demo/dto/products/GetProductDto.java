package com.example.demo.dto.products;

import com.example.demo.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GetProductDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static GetProductDto from(Product product) {
        GetProductDto dto = new GetProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImageUrl(product.getImageUrl());
        return dto;
    }
}