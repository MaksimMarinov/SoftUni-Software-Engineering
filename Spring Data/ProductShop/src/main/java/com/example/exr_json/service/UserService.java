package com.example.exr_json.service;

import com.example.exr_json.model.dto.UserSeedDto;
import com.example.exr_json.model.entity.Product;
import com.example.exr_json.model.entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User findRandom();

    void seedUsers() throws FileNotFoundException;

    void findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName() throws IOException;

    void getUsersWhoHaveAtLeastOneProductSoldOrderByNumberOfProductsSoldThenLastName() throws IOException;
}
