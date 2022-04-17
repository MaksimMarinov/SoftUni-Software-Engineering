package com.example.jsonprocessing.Service.impl;

import com.example.jsonprocessing.Model.Dto.ProductShopDtos.ProductNameAndPriceDto;
import com.example.jsonprocessing.Model.Dto.ProductShopDtos.ProductSeedDto;
import com.example.jsonprocessing.Model.Entity.ProductShopEntity.Product;
import com.example.jsonprocessing.Repository.ProductRepository;
import com.example.jsonprocessing.Service.CategoryService;
import com.example.jsonprocessing.Service.ProductService;
import com.example.jsonprocessing.Service.UserService;
import com.example.jsonprocessing.Util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.jsonprocessing.constants.GlobalConstant.RESOURCE_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private static final String PRODUCT_FILE_PATH = "products.json";
    private final UserService userService;
    private final CategoryService categoryService;


    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws IOException {
        if(productRepository.count()>0){
            System.out.println("Products already seeded");
            return;
        }
        String fileContent = Files.readString(Path.of(RESOURCE_FILE_PATH + PRODUCT_FILE_PATH));
        ProductSeedDto[] productSeedDtos = gson.fromJson(fileContent, ProductSeedDto[].class);
        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.findRandomUser());
                    if (productSeedDto.getPrice().compareTo(BigDecimal.valueOf(500L)) > 0) {
                        product.setBuyer(userService.findRandomUser());
                        if(product.getBuyer().getId().equals(product.getSeller().getId())){
                            product.setBuyer(null);
                        }
                    }
                 product.setCategories(categoryService.findRandomCategories());

                    return product;

                }).forEach(productRepository::save);


    }

    @Override
    public List<ProductNameAndPriceDto> findAllProductsIndRange(BigDecimal lower, BigDecimal upper) {

        return productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(lower, upper)
                .stream()
                .map(product -> {
                    ProductNameAndPriceDto productNameAndPriceDto = modelMapper.map(product, ProductNameAndPriceDto.class);
                    productNameAndPriceDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(), product.getSeller().getLastName()));
                    return productNameAndPriceDto;
                }).collect(Collectors.toList());
    }


}
