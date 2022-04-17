package com.example.jsonprocessing.Service;

import com.example.jsonprocessing.Model.Dto.ProductShopDtos.CategoriesByProductsCountDto;
import com.example.jsonprocessing.Model.Entity.ProductShopEntity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;
    Set<Category> findRandomCategories();

    List<CategoriesByProductsCountDto> findCategoriesByProductCount();
}
