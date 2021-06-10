package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Vehicle car = createVehicle(bf);
        Vehicle truck = createVehicle(bf);
        int numberOfOperations = Integer.parseInt(bf.readLine());
        while (numberOfOperations-->0){
            String[] tokens = readArray(bf);
            String command =  tokens[0];
            String type = tokens[1];
            double value = Double.parseDouble(tokens[2]);
            if(command.equals("Drive")){
                if(type.equals("Car")){
                    car.drive(value);
                }else if(type.equals("Truck")){
                    truck.drive(value);
                }
            }else if(command.equals("Refuel")){
                if(type.equals("Car")){
                    car.refuel(value);
                }else if(type.equals("Truck")){
                    truck.refuel(value);
                }
            }

        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }

    private static Vehicle createVehicle(BufferedReader bf) throws IOException {

        String[] vehicleInfo = readArray(bf);
        String type = vehicleInfo[0];
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumption = Double.parseDouble(vehicleInfo[2]);
        if(type.equals("Car")){
            return new Car(fuelQuantity, fuelConsumption);
        }else if(type.equals("Truck")){
            return new Truck(fuelQuantity, fuelConsumption);
        }
        return null;

    }
    public static String[] readArray(BufferedReader bf) throws IOException {
        return bf.readLine().split("\\s+");
    }

}
