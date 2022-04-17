package com.example.exr_json.repo;

import com.example.exr_json.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c ORDER BY size(c.products) DESC ")
    List<Category> findAllByNumberOfProductsInCategory();
}
