package com.example.springdataautomapingobjects.Service.impl;

import com.example.springdataautomapingobjects.Module.Entity.Game;
import com.example.springdataautomapingobjects.Repository.GameRepository;
import com.example.springdataautomapingobjects.Service.UserGameService;
import org.springframework.stereotype.Service;

@Service
public class UserGameServiceImpl implements UserGameService {
    private final GameRepository gameRepository;

    public UserGameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game findGame(String title) {

        return this.gameRepository.findByTitle(title).orElse(null);
    }
}
