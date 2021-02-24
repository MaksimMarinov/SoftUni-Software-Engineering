package rawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (n-->0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Tire[] tires = new Tire[4];
            int index=0;
            for (int i = 5; i < tokens.length; i+=2) {
                Tire tire = new Tire(Double.parseDouble(tokens[i]),  Integer.parseInt(tokens[i+1]) );
                tires[index++] = tire;
            }
          Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tires );
            cars.add(car);
        }
       String cargoTypeCheck = scanner.nextLine();
        switch (cargoTypeCheck){
            case"fragile":
                cars.stream().filter(c->c.getCargo().getCargoType().equals("fragile"))
                        .filter(car -> Arrays.stream(car.getTiers()).anyMatch(tire -> tire.getPressure()<1))
                        .forEach(System.out::println);
                break;
            case"flamable":
                cars.stream().filter(c->c.getCargo().getCargoType().equals("flamable"))
                        .filter(car->car.getEngine().getEnginePower()>250)
                        .forEach(System.out::println);
                break;
        }

    }

}
