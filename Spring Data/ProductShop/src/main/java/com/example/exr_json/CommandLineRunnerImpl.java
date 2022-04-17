package com.example.exr_json;

import com.example.exr_json.service.CategoryService;
import com.example.exr_json.service.ProductService;
import com.example.exr_json.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final Scanner sc = new Scanner(System.in);
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public CommandLineRunnerImpl(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        // 2. Seed the Database
        seedDatabase();

        // 3. Query and Export data
        System.out.print("Enter Query number [1-4] or 0 for EXIT: ");
        switch (Integer.parseInt(sc.nextLine())) {
            // 3.1 Products in Range
            case 1 -> productService.findProductsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
            // 3.2 Successfully Sold Products
            case 2 -> userService.findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName();
            // 3.3 Categories by Products Count
            case 3 -> categoryService.getAllCategoriesOrderByNumberOfProductsPerCategory();
            // 3.4 Users and Products
            case 4 -> userService.getUsersWhoHaveAtLeastOneProductSoldOrderByNumberOfProductsSoldThenLastName();
            case 0 -> System.exit(0);
        }
    }

    private void seedDatabase() throws FileNotFoundException {
        userService.seedUsers();
        categoryService.seedCategories();
        productService.seedProducts();
    }
}
