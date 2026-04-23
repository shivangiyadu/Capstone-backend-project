package com.example.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    @Id
//    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne
    private  Category category;

}
