package com.example.demo.dto.fakestore;

import lombok.Getter;
import lombok.Setter;
import com.example.demo.models.Product;

@Getter
@Setter

public class FakeStoreGetProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public Product toProduct() {
        Product product1 = new Product();
        product1.setId(this.getId());
        product1.setTitle(this.getTitle());
        product1.setDescription(this.getDescription());
        product1.setImageUrl(this.getImage());
        //product1.setCategoryName(this.getCategory());
//        Category category1 = new Category();
//        category1.setName(category);
//        product1.setCategory(category1);
//        product1.setPrice(this.getPrice());

        return product1;
    }
}
