import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Vehicles> allVehicles = new ArrayList<>();
        while (!line.equals("End")){
            String[] data = line.split("\\s+");
            String type = data[0];
            String model = data[1];
            String color = data[2];
            int horsePower = Integer.parseInt(data[3]);

            Vehicles vehicles = new Vehicles(type, model, color, horsePower );
            allVehicles.add(vehicles);
            line= scanner.nextLine();
        }
        line= scanner.nextLine();
        while (!line.equals("Close the Catalogue")){
            String model = line;
            allVehicles.stream().filter(vehicles -> vehicles.getModel().equals(model)).
                    forEach(vehicles -> System.out.println(vehicles.toString()));

            line= scanner.nextLine();
        }
        List<Vehicles> cars = allVehicles.stream().filter(vehicles -> vehicles.getType().equals("car"))
                .collect(Collectors.toList());
       List<Vehicles> trucks = allVehicles.stream().filter(vehicles -> vehicles.getType().equals("truck"))
               .collect(Collectors.toList());

       System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsePowerNew(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.",averageHorsePowerNew(trucks));

    }
    private static class Vehicles{
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicles(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }
        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",getType().toUpperCase().charAt(0)+
                    getType().substring(1), getModel(), getColor(), getHorsePower());
        }
    }
    public static double averageHorsePowerNew(List<Vehicles> vehicles){
        if(vehicles.size()==0){
            return 0.0;
        }
        return vehicles.stream().mapToDouble(Vehicles::getHorsePower).sum()/vehicles.size();
    }


}


