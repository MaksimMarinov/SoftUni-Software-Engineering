package BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
           String command = bf.readLine();
        ArrayDeque<Citizen> idPeople = new ArrayDeque<>();
        ArrayDeque<Robot> idRobots = new ArrayDeque<>();
           while (!command.equals("End")){
               String[] tokens = command.split("\\s+");
               String name;
               String model;
               String id;
               int age;
               if(tokens.length==3){
                   name = tokens[0];
                   age = Integer.parseInt(tokens[1]);
                   id=tokens[2];
                   Citizen citizen = new Citizen(name, age, id);
                   idPeople.push(citizen);
               }else{
                   model = tokens[1];
                   id=tokens[0];
                   Robot robot = new Robot(id, model);
                   idRobots.push(robot);
               }



               command=bf.readLine();
           }
           String lastIdNumber = bf.readLine();
           idPeople.stream().filter(citizen -> citizen.getId().endsWith(lastIdNumber)).forEach(citizen -> System.out.println(citizen.getId())  );
           idRobots.stream().filter(robot -> robot.getId().endsWith(lastIdNumber)).forEach(robot->System.out.println(robot.getId()));

    }
}
