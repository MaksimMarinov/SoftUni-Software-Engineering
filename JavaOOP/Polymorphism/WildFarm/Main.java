package WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        ArrayList<Animal> animalList = new ArrayList<>();
        while (!"End".equals(line = bf.readLine())){
            String[] animalInfo = line.split("\\s+");
            Animal animal = createAnimal(animalInfo);
            String[] foodInfo = bf.readLine().split("\\s+");
            Food food = createFood(foodInfo);
            animal.makeSound();
            try {
                animal.eat(food);
            }catch (IllegalStateException i){
                System.out.println(i.getMessage());
            }


            animalList.add(animal);
        }
        animalList.forEach(System.out::println);
    }

    private static Food createFood(String[] foodInfo) {
        String foodType = foodInfo[0];
        int quantity = Integer.parseInt(foodInfo[1]);
        Food food = null;
        if(foodType.equals("Vegetable")){
            food = new Vegetable(quantity) ;
        }else if(foodType.equals("Meat")){
            food=new Meat(quantity);
        }
        return food;
    }

    private static Animal createAnimal(String[] animalInfo) {
        String animalType =  animalInfo[0];
        String animalName = animalInfo[1];
        Double weight = Double.parseDouble(animalInfo[2]);
        String livingRegion =  animalInfo[3];
        Animal animal = null;
        switch (animalType){
            case"Cat":
                String breed = animalInfo[4];
                animal = new Cat(animalType, animalName, weight, livingRegion, breed);
                break;
            case"Tiger":
                animal=new Tiger(animalType, animalName, weight, livingRegion);
                break;
            case "Zebra":
                animal=new Zebra(animalType, animalName, weight, livingRegion);
                break;
            case"Mouse":
                animal=new Mouse(animalType, animalName, weight, livingRegion);
                break;

        }
        return animal;
    }
}
