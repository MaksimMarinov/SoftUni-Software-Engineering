package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String animalType = bf.readLine();
        while (!animalType.equals("Beast!")){
            String[] animalInfo = bf.readLine().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];
            try {
                createAnimal(animalType, name, age, gender);
            }catch (IllegalArgumentException e){
                System.out.println("Invalid input");
            }

            animalType=bf.readLine();
        }
    }

    private static void createAnimal(String type, String name, int age, String gender) {
        switch (type){
            case "Cat":
                Cat cat = new Cat(name, age, gender);
                System.out.println(cat);
                break;
            case"Dog":
                Dog dog = new Dog(name, age, gender);
                System.out.println(dog);
                break;
            case"Frog":
                Frog frog = new Frog(name, age, gender);
                System.out.println(frog);
                break;
            case"Kittens":
                Kitten kitten = new Kitten(name, age);
                System.out.println(kitten);
                break;
            case"Tomcat":
                Tomcat tomcat = new Tomcat(name, age);
                System.out.println(tomcat);
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }
}
