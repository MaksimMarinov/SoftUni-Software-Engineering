package com.example.exr_json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class SoldProductsDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<SoldProductWithBuyerDto> soldProducts;

    public SoldProductsDto() {
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

    public Set<SoldProductWithBuyerDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<SoldProductWithBuyerDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
