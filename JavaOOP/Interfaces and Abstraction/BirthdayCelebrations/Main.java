package BirthdayCelebrations;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        ArrayDeque<Citizen> citizens = new ArrayDeque<>();
        ArrayDeque<Robot> robots = new ArrayDeque<>();
        ArrayDeque<Pet> pets = new ArrayDeque<>();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            String id;
            String dateOfBirth;
            switch (type){
                case"Citizen":
                    int age = Integer.parseInt(tokens[2]);
                    id = tokens[3];
                    dateOfBirth=tokens[4];
                    Citizen citizen = new Citizen(name,age, id, dateOfBirth);
                    citizens.push(citizen);
                    break;
                case"Robot":
                    id = tokens[2];
                    Robot robot = new Robot(id, name);
                    robots.push(robot);
                    break;
                case"Pet":
                    dateOfBirth=tokens[2];
                    Pet pet = new Pet(name, dateOfBirth);
                    pets.push(pet);
                    break;
            }
            input= bf.readLine();
        }
        String year = bf.readLine();
        citizens.stream().filter(citizen -> citizen.getBirthDate().endsWith(year))
                .forEach(citizen -> System.out.println(citizen.getBirthDate()));
        pets.stream().filter(pet -> pet.getBirthDate().endsWith(year))
                .forEach(pet -> System.out.println( pet.getBirthDate()));

    }
}


