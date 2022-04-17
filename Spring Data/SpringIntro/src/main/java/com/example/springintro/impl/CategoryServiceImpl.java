package com.example.springintro.impl;

import com.example.springintro.Entity.Category;
import com.example.springintro.Service.CategoryService;
import com.example.springintro.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String categoriesPath = "src/main/resources/categories.txt";
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        if(categoryRepository.count()>0){
            return;
        }
        Files.readAllLines(Path.of(categoriesPath))
                .stream().filter(row->!row.isEmpty())
                .forEach(categoryName->{
                    Category category = new Category(categoryName);

                    categoryRepository.save(category);
                });


    }

    @Override
    public Set<Category> getRandomCategories() {
       Set<Category> categories = new HashSet<>();
       int randomInteger = ThreadLocalRandom.current().nextInt(1,3);
       Long countRepCount = categoryRepository.count();
        for (int i = 0; i < randomInteger; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, countRepCount+1);
            Category category = categoryRepository.findById(randomId).orElse(null);
            categories.add(category);
        }
        return categories;
    }
}
