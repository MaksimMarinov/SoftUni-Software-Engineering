package com.example.exr_json.service;

import com.example.exr_json.model.dto.CategorySeedDto;
import com.example.exr_json.model.entity.Category;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws FileNotFoundException;

    Set<Category> findRandomCategories();

    void getAllCategoriesOrderByNumberOfProductsPerCategory() throws IOException;
}
