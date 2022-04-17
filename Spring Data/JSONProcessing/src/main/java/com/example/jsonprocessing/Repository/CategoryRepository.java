package com.example.jsonprocessing.Repository;

import com.example.jsonprocessing.Model.Entity.ProductShopEntity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c from Category c")
    List<Category> getAllCategoriesWithProductInfo();
}
