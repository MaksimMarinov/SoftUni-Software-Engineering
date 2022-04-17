package com.example.springdataautomapingobjects.Service.impl;

import com.example.springdataautomapingobjects.Module.DTO.UserLoginDto;
import com.example.springdataautomapingobjects.Module.DTO.UserRegisterDto;
import com.example.springdataautomapingobjects.Module.Entity.Game;
import com.example.springdataautomapingobjects.Module.Entity.User;
import com.example.springdataautomapingobjects.Repository.UserRepository;
import com.example.springdataautomapingobjects.Service.UserGameService;
import com.example.springdataautomapingobjects.Service.UserService;
import com.example.springdataautomapingobjects.Util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;
    private Set<Game> shoppingCard;
    private UserGameService userGameService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserGameService userGameService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userGameService = userGameService;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {

        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmedPassword())) {
            System.out.println("WrongConfirmPass");
        }
        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.violation(userRegisterDto);

        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        User user = modelMapper.map(userRegisterDto, User.class);
        userRepository.save(user);
        System.out.println(userRegisterDto.getFullName() + " was registered");
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violation = validationUtil.violation(userLoginDto);
        if (!violation.isEmpty()) {
            violation.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        User user = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword()).orElse(null);
        if (user == null) {
            System.out.println("Incorrect username / password");
            return;
        }


        if (loggedInUser != null && user.getFullName().equals(loggedInUser.getFullName())) {
            System.out.println("this user is already logged in");
            return;
        }

        if (user.getId() == 1) {
            user.setAdministrator(true);
            System.out.println(user.getFullName() + " is administrator");
            this.userRepository.save(user);
        }
        loggedInUser = user;
        System.out.println("Successfully logged in " + user.getFullName());
    }

    @Override
    public void logOut() {
        if (loggedInUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }
        loggedInUser.setAdministrator(false);
        userRepository.save(loggedInUser);
        System.out.printf("User %s successfully logged out%n", loggedInUser.getFullName());
        loggedInUser = null;
    }

    @Override
    public boolean hasLoggedIn() {
        return loggedInUser != null;
    }

    @Override
    public boolean isAdmin() {
        return this.loggedInUser.isAdministrator();
    }

    @Override
    public void addGame(String gameName) {
        Game game = getGame(gameName);
        if (game == null) return;

        Set<Game> games = loggedInUser.getGames();
        for (Game game1 : games) {
            if(Objects.equals(game.getId(), game1.getId())){
                System.out.println("User already bought this game");
                return;
            }
        }

        if(this.shoppingCard==null){
            this.shoppingCard= new HashSet<>();
        }
        for (Game game1 : shoppingCard) {
            if(Objects.equals(game.getId(), game1.getId())){
                System.out.println("this game is already to shopping card");
                return;
            }
        }

        this.shoppingCard.add(game);
        System.out.println(game.getTitle() + " added to cart.");

    }



    @Override
    public void removeItem(String gameName) {
        Game game = getGame(gameName);
        if (game == null) return;
        if(this.shoppingCard==null||this.shoppingCard.isEmpty()){
            System.out.println("Shoping card is empty");
            return;
        }
        for (Game game1 : this.shoppingCard) {
            if(Objects.equals(game.getId(), game1.getId())){
                System.out.println(game.getTitle() + " removed from cart.");
                this.shoppingCard.remove(game1);
                return;
            }
        }

            System.out.println("No such game in shopping card");


    }

    @Override
    public void buyItem() {
        if(!hasLoggedIn()){
            System.out.println("no user logged in");
            return;
        }
        if(this.shoppingCard.isEmpty()){
            System.out.println("No games in shopping card");
        }
        Set<Game> userGames = this.loggedInUser.getGames();
        userGames.addAll(this.shoppingCard);
        this.loggedInUser.setGames(userGames);
        System.out.println("Successfully bought games: ");
        this.shoppingCard.forEach(game -> {
            System.out.println(" -"+game.getTitle());
        });
        this.shoppingCard=new HashSet<>();
        this.userRepository.save(loggedInUser);
    }

    @Override
    public void ownedGames() {
        loggedInUser.getGames().forEach(game-> System.out.println(game.getTitle()));
    }

    private Game getGame(String gameName) {
        Game game = this.userGameService.findGame(gameName);
        if(game==null){
            System.out.println("No game with that title");
            return null;
        }
        if(!hasLoggedIn()){
            System.out.println("no user logged in");
            return null;
        }
        return game;
    }
}
