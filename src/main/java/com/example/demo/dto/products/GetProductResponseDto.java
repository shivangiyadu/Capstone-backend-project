package com.example.demo.dto.products;
import com.example.demo.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String imageUrl;
    private String description;

    public static GetProductResponseDto from(Product product) {
        GetProductResponseDto getProductResponseDto = new GetProductResponseDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setImageUrl(product.getImageUrl());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setTitle(product.getTitle());

        return getProductResponseDto;
    }

}
