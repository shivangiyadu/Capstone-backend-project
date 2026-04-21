package com.example.demo.repositaries;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositary extends JpaRepository<Category,Long> {


}
