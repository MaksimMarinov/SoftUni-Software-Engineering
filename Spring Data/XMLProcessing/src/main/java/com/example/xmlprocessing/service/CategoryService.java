package com.example.xmlprocessing.service;

import com.example.xmlprocessing.model.dto.CategorySeedDto;
import com.example.xmlprocessing.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);
    long entityCount();
    Set<Category> getRandomCategories();
}
