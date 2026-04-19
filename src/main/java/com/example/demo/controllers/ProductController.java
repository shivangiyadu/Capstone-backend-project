package com.example.demo.controllers;

import com.example.demo.dto.CreateProductRequestDto;
import com.example.demo.dto.CreateProductResponseDto;
import com.example.demo.dto.GetAllProductResponseDto;
import com.example.demo.dto.GetProductDto;
import com.example.demo.dto.GetProductResponseDto;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService)

//     public ProductController(@Qualifier("fakeStore") ProductService productService)
     {
         this.productService=productService;
     }

    @PostMapping("")
     public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) //Spring converts incoming JSON to createProductResponseDto automatically.
    {
        Product product=productService.createProduct(  // here we're sending the entity to the service layer,which does all the real work
                createProductRequestDto.toProduct()
        );
        return CreateProductResponseDto.fromProduct(
                product); //converts entity back to response DTO
    }

    @GetMapping("")
    public GetAllProductResponseDto getAllProducts()
    {
        List<Product> products=productService.getAllProducts();
        GetAllProductResponseDto response=new GetAllProductResponseDto();

        List<GetProductResponseDto> getProductResponseDtos=new ArrayList<>();
        for(Product product:products)
        {
            getProductResponseDtos.add(GetProductResponseDto.from(product));
        }

        response.setProducts(getProductResponseDtos);
        return response;
    }
    @GetMapping("{id}") //id is path varibale
    public String getSingleProduct(@PathVariable("id")Long id)
    {
         return "Here is product id :"+id;
    }

    @RequestMapping(name="Shivangi",value="/products/")
    public String jhshii()
    {
        return "Magic";
    }

}

