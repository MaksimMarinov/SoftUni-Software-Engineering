package com.example.exr_json.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductsNamePriceDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public ProductsNamePriceDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
