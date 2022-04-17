package com.example.xmlprocessing.service;

import com.example.xmlprocessing.model.dto.ProductsInRangeRootDto;
import com.example.xmlprocessing.model.dto.ProductsSeedDto;
import com.example.xmlprocessing.model.dto.ProductsSeedRootDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Long entityCount();


    void seedProducts(List<ProductsSeedDto> products);

    ProductsInRangeRootDto productInRange();
}
