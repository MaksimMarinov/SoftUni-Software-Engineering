package com.example.xmlprocessing.service.impl;

import com.example.xmlprocessing.model.dto.CategorySeedDto;
import com.example.xmlprocessing.model.entity.Category;
import com.example.xmlprocessing.repository.CategoryRepository;
import com.example.xmlprocessing.service.CategoryService;
import com.example.xmlprocessing.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtill;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtill) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtill = validationUtill;
    }


    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        if(this.categoryRepository.count()>0){
            System.out.println("categories already seeded");
            return;
        }
        categories.stream()
                .filter(validationUtill::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public long entityCount() {
        return categoryRepository.count();
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        long categoriesCount = categoryRepository.count();
        for (int i = 0; i < 2; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, categoriesCount);
            Category category = categoryRepository.findById(randomId).orElse(null);
            if (categories.isEmpty()){
                categories.add(category);
            }
            for (Category category1 : categories) {
                if (!category1.getId().equals(category.getId())){
                    categories.add(category);
                    break;
                }
            }

        }
        return categories;
    }

}
