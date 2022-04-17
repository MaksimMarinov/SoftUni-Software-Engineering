package com.example.exr_json.service.impl;

import com.example.exr_json.model.dto.*;
import com.example.exr_json.model.entity.User;
import com.example.exr_json.repo.UserRepo;
import com.example.exr_json.service.UserService;
import com.example.exr_json.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final String USERS_FILE = "src/main/resources/users.json";
    private static final String OUTPUT_USERS_SOLD_PRODUCTS_FILE = "src/main/resources/out/users-sold-products.json";
    private static final String OUTPUT_USERS_AND_PRODUCTS_FILE = "src/main/resources/out/users-and-products.json";

    private final UserRepo userRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public UserServiceImpl(UserRepo userRepo, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.userRepo = userRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        if (userRepo.count() == 0) {
            final UserSeedDto[] users = gson.fromJson(new FileReader(USERS_FILE), UserSeedDto[].class);

            Arrays.stream(users)
                    .filter(validationUtil::isValid)
                    .map(user -> modelMapper.map(user, User.class))
                    .forEach(userRepo::save);
        }
    }


    @Override
    public User findRandom() {
        return userRepo.findById(
                ThreadLocalRandom.current().nextLong(1, userRepo.count() + 1))
                .orElse(null);
    }

    @Override
    public void findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName() throws IOException {

        final List<User> users = userRepo.findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName();

        final List<SoldProductsDto> soldProductsDtos = users.stream()
                .map(user -> modelMapper.map(user, SoldProductsDto.class))
                .collect(Collectors.toList());

        FileWriter fw = new FileWriter(OUTPUT_USERS_SOLD_PRODUCTS_FILE);
        gson.toJson(soldProductsDtos, fw);
        fw.close();
        System.out.println("File created: \n\t" + OUTPUT_USERS_SOLD_PRODUCTS_FILE);
    }

    @Override
    public void getUsersWhoHaveAtLeastOneProductSoldOrderByNumberOfProductsSoldThenLastName() throws IOException {
        final List<User> users = userRepo.findAllUsersWithMoreThanOneSoldProductOrderByNumberOfProductsSold();

        final UsersCountDto usersCountDto = modelMapper.map(users, UsersCountDto.class);
        usersCountDto.setUsersCount((long) users.size());

        usersCountDto.setUsers(users.stream()
                .map(user -> modelMapper.map(user, UserNamesAgeSoldProductsDto.class))
                .collect(Collectors.toSet()));

        FileWriter fw = new FileWriter(OUTPUT_USERS_AND_PRODUCTS_FILE);
        gson.toJson(usersCountDto, fw);
        fw.close();
        System.out.println("File created: \n\t" + OUTPUT_USERS_AND_PRODUCTS_FILE);
    }
}
