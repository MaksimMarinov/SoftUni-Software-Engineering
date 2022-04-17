package com.example.jsonprocessing.Service.impl;

import com.example.jsonprocessing.Model.Dto.ProductShopDtos.CategoriesByProductsCountDto;
import com.example.jsonprocessing.Model.Dto.ProductShopDtos.CategorySeedDto;
import com.example.jsonprocessing.Model.Entity.ProductShopEntity.Category;
import com.example.jsonprocessing.Model.Entity.ProductShopEntity.Product;
import com.example.jsonprocessing.Repository.CategoryRepository;
import com.example.jsonprocessing.Service.CategoryService;
import com.example.jsonprocessing.Util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonprocessing.constants.GlobalConstant.RESOURCE_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private static final String CATEGORIES_FILE_NAME = "categories.json";
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }
        String fileContent = Files.readString(Path.of(RESOURCE_FILE_PATH + CATEGORIES_FILE_NAME));

        CategorySeedDto[] categorySeedDtos = gson.fromJson(fileContent, CategorySeedDto[].class);
        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> findRandomCategories() {
        // не можах да разбера защо hashseta ми вкарваше eдни и същи категории повече от веднъж и гърмеше програмата
        //затова се наложиха тези безумни проверки и фор цикъл във фор цикъл
        Set<Category> categories = new HashSet<>();
        int catCount = ThreadLocalRandom.current().nextInt(1, 3);
        long totalCategoryRepositoryCount = this.categoryRepository.count()+1;
        for (int i = 0; i < catCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, totalCategoryRepositoryCount);
            Category category = this.categoryRepository.findById(randomId).orElse(null);
            if (categories.isEmpty()) {
                categories.add(category);
            }
            boolean isIn = false;
            for (Category category1 : categories) {
                if (category != null && category1.getId().equals(category.getId())) {
                    isIn = true;
                    break;
                }
            }
        if(!isIn){
            categories.add(category);
        }

        }
        return categories;
    }

    @Override
    public List<CategoriesByProductsCountDto> findCategoriesByProductCount() {

        return categoryRepository.getAllCategoriesWithProductInfo()
                .stream()
                .map(category -> {
                    CategoriesByProductsCountDto categoriesByProductsCountDto =
                            new CategoriesByProductsCountDto();
                    categoriesByProductsCountDto.setCategory(category.getName());
                    categoriesByProductsCountDto.setProductsCount((long) category.getProducts().size());
                    categoriesByProductsCountDto.setAveragePrice(getAveragePrice(category.getProducts()));
                    categoriesByProductsCountDto.setTotalRevenue(findTotalRevenue(category.getProducts()));
                    return categoriesByProductsCountDto;
                }).collect(Collectors.toList());

    }

    private Double findTotalRevenue(Set<Product> products) {
        return products.stream().mapToDouble(product -> Double.parseDouble(String.valueOf(product.getPrice())))
                .sum();
    }

    private Double getAveragePrice(Set<Product> products) {
        return products.stream()
                .mapToDouble(p -> p.getPrice().doubleValue())
                .average().getAsDouble();
    }


}
