package com.example.springdataautomapingobjects.Service;

import com.example.springdataautomapingobjects.Module.DTO.UserLoginDto;
import com.example.springdataautomapingobjects.Module.DTO.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logOut();

    boolean hasLoggedIn();

    boolean isAdmin();

    void addGame(String gameName);

    void removeItem(String gameName);

    void buyItem();

    void ownedGames();
}
