package com.example.springdataautomapingobjects.Service;

import com.example.springdataautomapingobjects.Module.Entity.Game;

public interface UserGameService {
    Game findGame(String title);
}
