package com.example.exr_json.service.impl;

import com.example.exr_json.model.dto.ProductRangeDto;
import com.example.exr_json.model.dto.ProductSeedDto;
import com.example.exr_json.model.entity.Product;
import com.example.exr_json.repo.ProductRepo;
import com.example.exr_json.service.CategoryService;
import com.example.exr_json.service.ProductService;
import com.example.exr_json.service.UserService;
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
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String PRODUCTS_FILE = "src/main/resources/products.json";
    private static final String OUTPUT_PRODUCTS_IN_RANGE_FILE = "src/main/resources/out/products-in-range.json";

    private final ProductRepo productRepo;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public ProductServiceImpl(ProductRepo productRepo, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.productRepo = productRepo;
        this.gson = gson;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        if (productRepo.count() == 0) {
            final ProductSeedDto[] products = gson.fromJson(new FileReader(PRODUCTS_FILE), ProductSeedDto[].class);

            Arrays.stream(products)
                    .filter(validationUtil::isValid)
                    .map(productSeedDto -> {
                        Product product = modelMapper.map(productSeedDto, Product.class);
                        if (product.getPrice().compareTo(BigDecimal.valueOf(350L)) > 0) {
                            product.setBuyer(userService.findRandom());
                        }
                        product.setSeller(userService.findRandom());
                        product.setCategories(categoryService.findRandomCategories());
                        return product;
                    })
                    .forEach(productRepo::save);
        }
    }

    @Override
    public void findProductsInRange(BigDecimal lower, BigDecimal upper) throws IOException {

        final List<Product> products = productRepo.findByPriceBetweenAndBuyerIsNullOrderByPrice(lower, upper);

        final List<ProductRangeDto> list = products.stream()
                .map(product -> {
                    final ProductRangeDto productRangeDto = modelMapper.map(product, ProductRangeDto.class);
                    productRangeDto.setSeller(
                            product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
                    return productRangeDto;
                })
                .collect(Collectors.toList());

        FileWriter fw = new FileWriter(OUTPUT_PRODUCTS_IN_RANGE_FILE);
        gson.toJson(list, fw);
        fw.close();
        System.out.println("File created: \n\t" + OUTPUT_PRODUCTS_IN_RANGE_FILE);
    }


}
