package com.example.demo.repositaries;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositary extends JpaRepository<Category,Long> {


    Optional<Category> findByName(String name);
    Category save(Category category);

}
