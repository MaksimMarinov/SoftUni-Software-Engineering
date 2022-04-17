package com.example.exr_json.model.dto;

import com.google.gson.annotations.Expose;

public class UserNamesAgeSoldProductsDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private CountProductsDto soldProducts;

    public UserNamesAgeSoldProductsDto() {

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public CountProductsDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(CountProductsDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
