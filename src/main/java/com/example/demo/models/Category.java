package com.example.demo.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity

public class Category extends BaseModel {

    @Column(nullable = false, unique = true)
    private String name;

    @Basic(fetch = FetchType.EAGER )
    private String description;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> featuredProducts;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="category",cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> allProducts;


    @OneToOne(cascade = CascadeType.ALL)
    private SubCategory subCategory;

}
