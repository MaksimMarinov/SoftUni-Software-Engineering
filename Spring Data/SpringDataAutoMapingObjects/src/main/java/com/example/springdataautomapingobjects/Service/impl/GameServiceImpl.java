package com.example.springdataautomapingobjects.Service.impl;

import com.example.springdataautomapingobjects.Module.DTO.GameAddDto;
import com.example.springdataautomapingobjects.Module.Entity.Game;
import com.example.springdataautomapingobjects.Repository.GameRepository;
import com.example.springdataautomapingobjects.Service.GameService;
import com.example.springdataautomapingobjects.Service.UserService;
import com.example.springdataautomapingobjects.Util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if(!userService.hasLoggedIn()){
            System.out.println("No user has logged in");
            return;
        }
        Set<ConstraintViolation<GameAddDto>> violation = validationUtil.violation(gameAddDto);
        if(!violation.isEmpty()){
            violation.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }


        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper-> mapper.map(GameAddDto::getThumbnailURL, Game::setImageThumbnail));

        Game game = modelMapper.map(gameAddDto, Game.class);
        Game gameToCheck =  this.gameRepository.findByTitle(game.getTitle()).orElse(null);
        if(gameToCheck!=null){
            System.out.println("this game has already added");
            return;
        }

        gameRepository.save(game);
        System.out.println("Added game " + game.getTitle() );


    }

    @Override
    public void editGame(long id, String inputPrice, String inputSize) {
        String[] readInput = getStrings(inputPrice);
        BigDecimal price = new BigDecimal(readInput[1]);
        readInput = getStrings(inputSize);
        double size = Double.parseDouble(readInput[1]);
        if(!userService.isAdmin()){
            System.out.println("the user is not admin");
            return;
        }
        Game game = gameRepository.findById(id).orElse(null);
        if(game == null){
            System.out.println("no game found");
            return;
        }


       if(price.compareTo(BigDecimal.ZERO) <0||size<0){
           System.out.println("price or size cannot be bellow zero");
       }
        game.setPrice(price);
        game.setSize(size);
        System.out.println("Edited "+ game.getTitle());
        this.gameRepository.save(game);
    }

    @Override
    public void deleteGame(long id) {
        if(!userService.isAdmin()){
            System.out.println("User is not admin");
            return;
        }
    Game game = this.gameRepository.findById(id).orElse(null);
        if(game==null){
            System.out.println("no such game");
            return;
        }

        String name = game.getTitle();
        this.gameRepository.deleteById(game.getId());
        System.out.println("Deleted " + name);


    }

    @Override
    public void AllGames() {

        List<Game> games = this.gameRepository.findAll();
        if(games.isEmpty()){
            System.out.println("there are no games");
            return;
        }

        games.forEach(game -> {
            System.out.println(game.getTitle()+" "+ game.getPrice());
        });
    }

    @Override
    public void detailGame(String title) {
        Game game = this.gameRepository.findByTitle(title).orElse(null);
        if (game==null){
            System.out.println("no such game exist");
            return;
        }
        System.out.printf("Title: %s%n" +
                "Price: %.2f%n" +
                "Description: %s%n" +
                "Release date: %s%n", game.getTitle(), game.getPrice(), game.getDescription(), game.getReleaseDate().toString());
    }



    private String[] getStrings(String inputPrice) {
        return inputPrice.split("=");
    }


}
