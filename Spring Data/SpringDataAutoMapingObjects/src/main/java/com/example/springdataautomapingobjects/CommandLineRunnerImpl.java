package com.example.springdataautomapingobjects;

import com.example.springdataautomapingobjects.Module.DTO.GameAddDto;
import com.example.springdataautomapingobjects.Module.DTO.UserLoginDto;
import com.example.springdataautomapingobjects.Module.DTO.UserRegisterDto;
import com.example.springdataautomapingobjects.Service.GameService;
import com.example.springdataautomapingobjects.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final BufferedReader bf;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bf = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {


        while (true) {
            System.out.println("Please enter number of the task you want to check or if you finished checking enter end: ");

            String decision = bf.readLine();
            if(decision.equals("end")){
                break;
            }
            switch (decision) {
                case "1" -> System.out.println("Check the database");
                case "2" -> task2();
                case "3" -> task3();
                case "4" -> task4();
                case "5"->task5();
                default -> System.out.println("not valid task number");
            }

        }
        System.out.println("Please give me ten");
        System.out.println("Bye!");


    }

    private void task5() throws IOException {
        while (true){
            System.out.println("Please enter your commands or if you finished checking task 5 enter end");
            String command = bf.readLine();
            String gameName = "";
            if(command.contains("|")){
                String[] tokens =  command.split("\\|");
                command = tokens[0];
                gameName = tokens[1];
            }
            if(command.equals("end")){
                break;
            }

            switch (command) {
                case "AddItem" -> userService.addGame(gameName);
                case "RemoveItem" -> userService.removeItem(gameName);
                case "BuyItem" -> userService.buyItem();
                default -> System.out.println("not valid input");

            }
        }
    }

    private void task4() throws Exception {
        while (true){
            System.out.println("Please enter your commands or if you finished checking task 4 enter end");
            String command = bf.readLine();
            if(command.equals("end")){
                break;
            }
            String gameName = "";
            if(command.contains("|")){
                String[] tokens =  command.split("\\|");
                command = tokens[0];
                gameName = tokens[1];
            }
            switch (command) {
                case "AllGames" -> gameService.AllGames();
                case"DetailGame"->gameService.detailGame(gameName);
                case"OwnedGames"->userService.ownedGames();
                default -> System.out.println("not valid input");
            }
        }


    }


    private void task3() throws Exception {
        while (true){
            System.out.println("Please enter your commands or if you finished checking task 3 enter end");
            String[] commands = bf.readLine().split("\\|");
            if(commands[0].equals("end")){
                break;
            }
            switch (commands[0]) {
                case "AddGame" -> gameService.addGame(
                        new GameAddDto(commands[1], new BigDecimal(commands[2]),
                                Double.parseDouble(commands[3]), commands[4], commands[5], commands[6], LocalDate.parse(commands[7],
                                DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                case "EditGame" -> gameService.editGame(Long.parseLong(commands[1]),commands[2],
                        commands[3]);
                case "DeleteGame" ->gameService.deleteGame(Long.parseLong(commands[1]));
                default -> System.out.println("not valid input");
            }
        }

    }


    private void task2() throws Exception {
        while (true){
            System.out.println("Please enter your commands or if you finished checking task 2 enter end");
            String[] commands = bf.readLine().split("\\|");
            if(commands[0].equals("end")){
                break;
            }
            switch (commands[0]) {
                case "RegisterUser" -> userService.registerUser(
                        new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]));
                case "LoginUser" -> userService.loginUser(new UserLoginDto(commands[1], commands[2]));
                case "Logout" -> userService.logOut();
                default -> System.out.println("not valid input");
        }

        }

    }


}
