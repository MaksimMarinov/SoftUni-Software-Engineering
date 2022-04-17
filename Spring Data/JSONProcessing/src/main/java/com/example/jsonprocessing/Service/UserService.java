package com.example.jsonprocessing.Service;

import com.example.jsonprocessing.Model.Dto.ProductShopDtos.UserSoldDto;
import com.example.jsonprocessing.Model.Entity.ProductShopEntity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers() throws IOException;
    User findRandomUser();
    List<UserSoldDto> findAllUserWithSoldProducts();
}
