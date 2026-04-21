package com.example.demo.dto.fakestore;

import com.example.demo.models.Category;
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
    private Category category;
    public static FakeStoreCreateProductRequestDto fromProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = new FakeStoreCreateProductRequestDto();
        fakeStoreCreateProductRequestDto.title = product.getTitle();
        fakeStoreCreateProductRequestDto.description = product.getDescription();
        fakeStoreCreateProductRequestDto.category = product.getCategory();
        fakeStoreCreateProductRequestDto.price = product.getPrice();
        fakeStoreCreateProductRequestDto.image = product.getImageUrl();

        return fakeStoreCreateProductRequestDto;
    }
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
