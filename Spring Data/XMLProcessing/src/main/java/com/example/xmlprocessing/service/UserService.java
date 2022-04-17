package com.example.xmlprocessing.service;

import com.example.xmlprocessing.model.dto.UserViewRootDto;
import com.example.xmlprocessing.model.dto.UsersSeedDto;
import com.example.xmlprocessing.model.entity.User;

import java.util.List;

public interface UserService {
    void seedUsers(List<UsersSeedDto> usersSeedDtoList);
    Long entityCount();
    User getRandomUser();

    UserViewRootDto findUsersWithMoreThanOneSoldProduct();
}
