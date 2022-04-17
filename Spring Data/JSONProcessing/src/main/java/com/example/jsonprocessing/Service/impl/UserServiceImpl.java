package com.example.jsonprocessing.Service.impl;

import com.example.jsonprocessing.Model.Dto.ProductShopDtos.UserSeedDto;
import com.example.jsonprocessing.Model.Dto.ProductShopDtos.UserSoldDto;
import com.example.jsonprocessing.Model.Entity.ProductShopEntity.User;
import com.example.jsonprocessing.Repository.UserRepository;
import com.example.jsonprocessing.Service.UserService;
import com.example.jsonprocessing.Util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonprocessing.constants.GlobalConstant.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    private static final String USER_FILE_PATH ="users.json";

    public UserServiceImpl(UserRepository userRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers() throws IOException {
        if(this.userRepository.count()>0){
            System.out.println("users ae already seeded");
            return;
        }
        Arrays.stream(gson.fromJson( Files.readString(Path.of(RESOURCE_FILE_PATH+USER_FILE_PATH)), UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto,User.class))
                .forEach(this.userRepository::save);



    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count()+1);
        return userRepository.findById(randomId)
                .orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUserWithSoldProducts() {

        return userRepository.findAllUsersWithMoreThanOneSoldProductsOrderByLastNameThanFirstName()
                .stream().map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }
}
