package com.example.jsonprocessing.Model.Dto.ProductShopDtos;

import com.google.gson.annotations.Expose;

public class CategoriesByProductsCountDto {
    public CategoriesByProductsCountDto() {
    }

    @Expose
    private String category;
    @Expose
    private Long productsCount;
    @Expose
    private Double averagePrice;
    @Expose
    private Double totalRevenue;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(Long productsCount) {
        this.productsCount = productsCount;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
