package com.example.springdataautomapingobjects.Service;

import com.example.springdataautomapingobjects.Module.DTO.GameAddDto;
import com.example.springdataautomapingobjects.Module.Entity.Game;


public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(long parseLong, String readInput, String readInput2);

    void deleteGame(long parseLong);
void AllGames();

   void detailGame(String gameName);

}
