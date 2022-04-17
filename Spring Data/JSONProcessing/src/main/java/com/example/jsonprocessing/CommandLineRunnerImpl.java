package com.example.jsonprocessing;

import com.example.jsonprocessing.Model.Dto.ProductShopDtos.CategoriesByProductsCountDto;
import com.example.jsonprocessing.Model.Dto.ProductShopDtos.ProductNameAndPriceDto;
import com.example.jsonprocessing.Model.Dto.ProductShopDtos.UserSoldDto;
import com.example.jsonprocessing.Service.CategoryService;
import com.example.jsonprocessing.Service.ProductService;
import com.example.jsonprocessing.Service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final BufferedReader bf;
    private String decision;
    private final UserService userService;
    private final Gson gson;
    private final ProductService productService;
    private static final String OUTPUT_PATH = "src/main/resources/files/out/";
    private static final String PRODUCT_IN_RANGE = "products_in_range.json";
    private static final String USERS_AND_SOLD_PRODUCTS = "users-and-sold=products.json";
    private static final String CATEGORIES_BY_PRODUCT_COUNT = "categories-by-product-count.json";

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.bf = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please enter the number of the task you want to check");
        System.out.println("Product shop tasks between 1-3");
        System.out.println("Car dealer between 4-6");

        this.decision=bf.readLine();
        while (!decision.equals("end")){
            switch (decision){
                case "1", "4" -> System.out.println("you can check the database");
                case "2"-> seedData();
                case "3"-> checkQueries();
                case "5"->seedCarDealer();
                default -> System.out.println("Not valid task number");
            }
            System.out.println("Please enter the task you want to check or if you done enter end");
            this.decision=bf.readLine();
        }
        System.out.println("Bye");
        bf.close();
    }

    private void seedCarDealer() {
    }

    private void checkQueries() throws IOException {
        System.out.println("Please enter the number of the query you want to check");

        this.decision=bf.readLine();
        while (!decision.equals("end")){
            switch (decision){
                case "1" -> productInRange();
                case "2" -> soldProducts();
                case "3" -> CategoriesByProductCount();
                case "4"-> System.out.println("Didn't do it");
                default -> System.out.println("Not valid task number");
            }
            System.out.println("Please enter the query you want to check or if you done enter end");
            this.decision=bf.readLine();
        }

    }

    private void CategoriesByProductCount() throws IOException {
        List<CategoriesByProductsCountDto> categoriesByProductsCountDtos = categoryService.findCategoriesByProductCount();
        String content = gson.toJson(categoriesByProductsCountDtos);
        writeToFile(OUTPUT_PATH+CATEGORIES_BY_PRODUCT_COUNT, content);
    }

    private void soldProducts() throws IOException {
        List<UserSoldDto> userSoldDtos = userService.findAllUserWithSoldProducts();
        String content = gson.toJson(userSoldDtos);
        writeToFile(OUTPUT_PATH+USERS_AND_SOLD_PRODUCTS,content);
    }

    private void productInRange() throws IOException {
        List<ProductNameAndPriceDto> productNameAndPriceDtos = productService.findAllProductsIndRange(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));
        String content = gson.toJson(productNameAndPriceDtos);
        writeToFile(OUTPUT_PATH+PRODUCT_IN_RANGE, content );
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files.write(Path.of(filePath), Collections.singleton(content));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();
    }
}
