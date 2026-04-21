package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Category extends BaseModel {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<Product> featuredProducts;

    @OneToMany(mappedBy="category")
    private List<Product> allPrducts;
}
