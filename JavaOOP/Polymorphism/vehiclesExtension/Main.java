package vehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Vehicle car = createVehicle(bf);
        Vehicle truck = createVehicle(bf);
        Bus bus = (Bus)createVehicle(bf);
        int numberOfOperations = Integer.parseInt(bf.readLine());
        while (numberOfOperations-->0){
            String[] tokens = readArray(bf);
            String command =  tokens[0];
            String type = tokens[1];
            double value = Double.parseDouble(tokens[2]);
            try {
                if(command.equals("Drive")){
                    if(type.equals("Car")){
                        car.drive(value);
                    }else if(type.equals("Truck")){
                        System.out.println(truck.drive(value));
                    }else if(type.equals("Bus")){
                        bus.setEmpty(false);
                        System.out.println(bus.drive(value));
                    }
                }else if(command.equals("Refuel")){
                    if(type.equals("Car")){
                        car.refuel(value);
                    }else if(type.equals("Truck")){
                        truck.refuel(value);
                    }else if(type.equals("Bus")){
                        bus.refuel(value);
                    }
                }else if(command.equals("DriveEmpty")){
                    System.out.println(bus.drive(value));
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }

    private static Vehicle createVehicle(BufferedReader bf) throws IOException {

        String[] vehicleInfo = readArray(bf);
        String type = vehicleInfo[0];
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumption = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);
        if(type.equals("Car")){
            return new Car(fuelQuantity, fuelConsumption, tankCapacity);
        }else if(type.equals("Truck")){
            return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
        }else if(type.equals("Bus")){
            return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }

        return null;

    }
    public static String[] readArray(BufferedReader bf) throws IOException {
        return bf.readLine().split("\\s+");
    }

}
