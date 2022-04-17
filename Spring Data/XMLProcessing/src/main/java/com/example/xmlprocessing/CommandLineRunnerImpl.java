package com.example.xmlprocessing;

import com.example.xmlprocessing.model.dto.*;
import com.example.xmlprocessing.service.CategoryService;
import com.example.xmlprocessing.service.ProductService;
import com.example.xmlprocessing.service.UserService;
import com.example.xmlprocessing.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private static final String RESOURCE_FILE_PATH = "src/main/resources/files/";
    private static final String OUT_FILE_PATH = "out/";
    private static final String CATEGORIES_FILE_NAME = "categories.xml";
    public static final String USERS_FILE_NAME = "users.xml";
    public static final String PRODUCTS_FILE_NAME = "products.xml";
    public static final String PRODUCTS_IN_RANGE_FILENAME = "products-in-range.xml";
    public static final String USER_SOLD_PRODUCTS_FILENAME = "users-sold-products.xml";
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private String decision;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please enter number of the task you want to check:");
        decision= bf.readLine();
        while (!decision.equals("end")){
            switch (decision){
                case "1"->task1();
                case "2" -> task2();
                default -> System.out.println("This is not valid task number");
            }
            System.out.println("If you want to check another task enter number 1 or 2 else enter end");
            decision=bf.readLine();
        }

    }

    private void task2() {
    }

    private void task1() throws IOException, JAXBException {
        System.out.println("if you want to seed the data please enter 1, if you want to check queries enter 2");
        decision = bf.readLine();
        while (!decision.equals("end")){
            switch (decision){
                case "1"->seedData();
                case "2"->checkQueries();
                default -> System.out.println("not valid input");

            }
            System.out.println("If you want to check another task from 1 enter 1 or 2 else enter end");
            decision=bf.readLine();
        }
    }

    private void checkQueries() throws IOException, JAXBException {
        System.out.println("Please enter number of query you want to check");
        decision = bf.readLine();
        while (!decision.equals("end")){
            switch (decision){
                case "1"->productsInRange();
                case "2"-> successfullySoldProducts();
                default -> System.out.println("not valid input");

            }
            System.out.println("If you want to check another task enter the number of query else enter end");
            decision=bf.readLine();
        }
    }

    private void successfullySoldProducts() throws JAXBException {
        UserViewRootDto userViewRootDto = userService
                .findUsersWithMoreThanOneSoldProduct();
        xmlParser.writeToFile(RESOURCE_FILE_PATH+OUT_FILE_PATH+USER_SOLD_PRODUCTS_FILENAME, userViewRootDto);
    }

    private void productsInRange() throws JAXBException {
        ProductsInRangeRootDto productsInRangeRootDto
                = productService.productInRange( );
        xmlParser.writeToFile(RESOURCE_FILE_PATH+OUT_FILE_PATH+PRODUCTS_IN_RANGE_FILENAME, productsInRangeRootDto);
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        seedCategories();
        seedUsers();
        seedProducts();
    }

    private void seedProducts() throws JAXBException, FileNotFoundException {
        if(productService.entityCount()==0){
            ProductsSeedRootDto productsSeedRootDto = xmlParser
                    .fromFile(RESOURCE_FILE_PATH + PRODUCTS_FILE_NAME, ProductsSeedRootDto.class);
            productService.seedProducts(productsSeedRootDto.getProducts());

        }
    }

    private void seedUsers() throws JAXBException, FileNotFoundException {
        if(userService.entityCount()==0){
            UsersSeedRootDto usersSeedRootDto = xmlParser
                    .fromFile(RESOURCE_FILE_PATH+USERS_FILE_NAME, UsersSeedRootDto.class);
            userService.seedUsers(usersSeedRootDto.getUsers());
        }

    }

    private void seedCategories() throws JAXBException, FileNotFoundException {
        if(categoryService.entityCount()==0){
            CategoriesSeedRootDto categoriesSeedRootDto = xmlParser.fromFile(RESOURCE_FILE_PATH+CATEGORIES_FILE_NAME, CategoriesSeedRootDto.class);
            categoryService.seedCategories(categoriesSeedRootDto.getCategories());
        }

    }
}
