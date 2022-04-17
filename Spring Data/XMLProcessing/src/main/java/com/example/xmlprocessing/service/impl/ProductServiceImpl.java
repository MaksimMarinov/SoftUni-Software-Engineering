package com.example.xmlprocessing.service.impl;

import com.example.xmlprocessing.model.dto.ProductsInRangeDto;
import com.example.xmlprocessing.model.dto.ProductsInRangeRootDto;
import com.example.xmlprocessing.model.dto.ProductsSeedDto;
import com.example.xmlprocessing.model.entity.Product;
import com.example.xmlprocessing.repository.ProductRepository;
import com.example.xmlprocessing.service.CategoryService;
import com.example.xmlprocessing.service.ProductService;
import com.example.xmlprocessing.service.UserService;
import com.example.xmlprocessing.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ValidationUtil validationUtil, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public Long entityCount() {
        return this.productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductsSeedDto> products) {
        if(productRepository.count()>0){
            System.out.println("products already seeded");
            return;
        }
        products.stream().filter(validationUtil::isValid)
                .map(productsSeedDto -> {
                    Product product =  modelMapper.map(productsSeedDto, Product.class);
                    product.setSeller(userService.getRandomUser());
                    if(product.getPrice().compareTo(BigDecimal.valueOf(600L))>0){

                        product.setBuyer(userService.getRandomUser());

                    }
                  product.setCategories(categoryService.getRandomCategories());
                  return product;
                })
                .forEach(productRepository::save);
    }

    @Override
    public ProductsInRangeRootDto productInRange() {
        ProductsInRangeRootDto productsInRangeRootDto = new ProductsInRangeRootDto();
        productsInRangeRootDto.setProducts(
                productRepository.findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                .stream().map(product -> {
                    ProductsInRangeDto productsInRangeDto =
                            modelMapper.map(product, ProductsInRangeDto.class);
                   productsInRangeDto.setSeller(String.format("%s %s", product.getSeller().getFirstName() == null? "":product.getSeller().getFirstName(),product.getSeller().getLastName()));
                return productsInRangeDto;
                })

                        .collect(Collectors.toList()));


        return productsInRangeRootDto;
    }


}
