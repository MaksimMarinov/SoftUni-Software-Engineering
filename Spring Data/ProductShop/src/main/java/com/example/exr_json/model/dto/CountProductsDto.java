package com.example.exr_json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class CountProductsDto {
    @Expose
    private Long count;
    @Expose
    private Set<ProductsNamePriceDto> products;

    public CountProductsDto() {
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Set<ProductsNamePriceDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductsNamePriceDto> products) {
        this.products = products;
    }
}
