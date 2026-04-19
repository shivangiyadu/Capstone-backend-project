package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import com.example.demo.models.Product;

@Getter
@Setter
public class FakeStoreCreateProductRequestDto {
    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;
    public static FakeStoreCreateProductRequestDto fromProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = new FakeStoreCreateProductRequestDto();
        fakeStoreCreateProductRequestDto.title = product.getTitle();
        fakeStoreCreateProductRequestDto.description = product.getDescription();
        fakeStoreCreateProductRequestDto.category = product.getCategoryName();
        fakeStoreCreateProductRequestDto.price = product.getPrice();
        fakeStoreCreateProductRequestDto.image = product.getImageUrl();

        return fakeStoreCreateProductRequestDto;
    }
}
