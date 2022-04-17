package com.example.jsonprocessing.Model.Dto.ProductShopDtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserSoldDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;

    private Set<ProductWithBuyerDto> soldProducts;

    public Set<ProductWithBuyerDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductWithBuyerDto> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public UserSoldDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
