package speedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<String, Car> cars = new LinkedHashMap<>();
       while (n-->0){
           String[] tokens = bf.readLine().split("\\s+");
           String model = tokens[0];
           double fuelAmount = Double.parseDouble(tokens[1]);
           double fuelCost = Double.parseDouble(tokens[2]);
           Car car =new Car(model, fuelAmount, fuelCost);
           cars.put(model, car);
       }
       String command = bf.readLine();
       while (!command.equals("End")){
           String[] tokens = command.split("\\s+");
           String model = tokens[1];
           double distance = Double.parseDouble(tokens[2]);
           Car car = cars.get(model);
           car.drive(distance);
           command = bf.readLine();
       }
       cars.values().forEach(car-> System.out.println(car));
    }
}
