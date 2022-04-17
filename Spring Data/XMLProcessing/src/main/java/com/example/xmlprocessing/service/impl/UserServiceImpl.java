package com.example.xmlprocessing.service.impl;

import com.example.xmlprocessing.model.dto.UserViewRootDto;
import com.example.xmlprocessing.model.dto.UserWithProductsDto;
import com.example.xmlprocessing.model.dto.UsersSeedDto;
import com.example.xmlprocessing.model.entity.User;
import com.example.xmlprocessing.repository.UserRepository;
import com.example.xmlprocessing.service.UserService;
import com.example.xmlprocessing.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
   private final UserRepository userRepository;
   private final ValidationUtil validationUtil;
   private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers(List<UsersSeedDto> usersSeedDtoList) {
        if(userRepository.count()>0){
            System.out.println("users already seeded");
            return;
        }
        usersSeedDtoList.stream()
                .filter(validationUtil::isValid)
                .map(usersSeedDto -> modelMapper.map(usersSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public Long entityCount() {
        return userRepository.count();
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count());

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public UserViewRootDto findUsersWithMoreThanOneSoldProduct() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();
        userViewRootDto.setUserSoldProductsDtos(userRepository.findAllUsersWithMoreThanOneSold()
        .stream()
        .map(user -> modelMapper.map(user, UserWithProductsDto.class)).collect(Collectors.toList()));
        return  userViewRootDto;
    }
}
