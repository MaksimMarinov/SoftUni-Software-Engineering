package com.example.exr_json.service.impl;

import com.example.exr_json.model.dto.CategoryProductsCountDto;
import com.example.exr_json.model.dto.CategorySeedDto;
import com.example.exr_json.model.entity.Category;
import com.example.exr_json.model.entity.Product;
import com.example.exr_json.repo.CategoryRepo;
import com.example.exr_json.service.CategoryService;
import com.example.exr_json.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_FILE = "src/main/resources/categories.json";
    private static final String OUTPUT_CATEGORIES_BY_PRODUCTS_FILE = "src/main/resources/out/categories-by-products.json";

    private final CategoryRepo categoryRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public CategoryServiceImpl(CategoryRepo categoryRepo, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.categoryRepo = categoryRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        if (categoryRepo.count() == 0) {
            final CategorySeedDto[] categories = gson.fromJson(new FileReader(CATEGORIES_FILE), CategorySeedDto[].class);

            Arrays.stream(categories)
                    .filter(validationUtil::isValid)
                    .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                    .forEach(categoryRepo::save);
        }
    }

    @Override
    public Set<Category> findRandomCategories() {
        return Set.of(Objects.requireNonNull(categoryRepo.findById(
                ThreadLocalRandom.current().nextLong(1, categoryRepo.count() + 1)) // random Category added.
                .orElse(null)));
    }

    @Override
    public void getAllCategoriesOrderByNumberOfProductsPerCategory() throws IOException {
        final List<Category> categories = categoryRepo.findAllByNumberOfProductsInCategory();

        final List<CategoryProductsCountDto> categoryProductsCountDtoList = categories.stream()
                .map(category -> {
                    CategoryProductsCountDto categoryProductsCountDto = modelMapper.map(category, CategoryProductsCountDto.class);

                    categoryProductsCountDto.setProductsCount((long) category.getProducts().size());

                    categoryProductsCountDto.setAveragePrice(
                            BigDecimal.valueOf(category
                                    .getProducts()
                                    .stream()
                                    .map(Product::getPrice)
                                    .mapToDouble(BigDecimal::doubleValue)
                                    .average()
                                    .orElse(0.0)));

                    categoryProductsCountDto.setTotalRevenue(
                            BigDecimal.valueOf(category
                                    .getProducts()
                                    .stream()
                                    .map(Product::getPrice)
                                    .mapToDouble(BigDecimal::doubleValue)
                                    .sum()));

                    return categoryProductsCountDto;
                })
                .collect(Collectors.toList());

        FileWriter fw = new FileWriter(OUTPUT_CATEGORIES_BY_PRODUCTS_FILE);
        gson.toJson(categoryProductsCountDtoList, fw);
        fw.close();
        System.out.println("File created: \n\t" + OUTPUT_CATEGORIES_BY_PRODUCTS_FILE);
    }
}
