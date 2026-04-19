package com.example.demo.services;

import com.example.demo.dto.FakeStoreCreateProductRequestDto;
import com.example.demo.dto.FakeStoreGetProductResponseDto;
import com.example.demo.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

@Service("fakeStoreProductService")
@Primary
public class ProductServiceFakestoreImpl implements ProductService {

    private RestTemplate restTemplate;

    public ProductServiceFakestoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product)
    {
        FakeStoreCreateProductRequestDto request=new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategoryName());
        request.setTitle(product.getTitle());
        request.setImage(product.getImageUrl());
        request.setDescription(product.getDescription());
        request.setPrice(product.getPrice());

       FakeStoreCreateProductRequestDto response= restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
               FakeStoreCreateProductRequestDto.class
        );
        Product product1=new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setImageUrl(response.getImage());
        product1.setDescription(response.getDescription());
        product1.setCategoryName(response.getCategory());
        product1.setPrice(response.getPrice());

        return product1;

    }
    @Override
    public List<Product> getAllProducts()
    {
        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject(
          "https://fakestoreapi.com/products",
          FakeStoreGetProductResponseDto[].class
        );
        List<FakeStoreGetProductResponseDto> responseDtoList=
                Stream.of(response).toList();

        List<Product> products=new ArrayList<>();

        for(FakeStoreGetProductResponseDto fakeStoreGetProductResponseDto:responseDtoList)
        {
            products.add(fakeStoreGetProductResponseDto.toProduct());
        }

        return products;
    }
}
