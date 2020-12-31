import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogueSoftUni {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Vehicles2> allVehicles = new ArrayList<>();
        while (!line.equals("End")) {
            String[] data = line.split("\\s+");
            String type = data[0];
            String model = data[1];
            String color = data[2];
            int horsePower = Integer.parseInt(data[3]);
           Vehicles2 vehicles = new Vehicles2(type, model, color, horsePower);
            allVehicles.add(vehicles);
            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!line.equals("Close the Catalogue")) {
            String model=line;
            allVehicles.stream().filter(vehicles -> vehicles.getModel().equals(model))
                    .forEach(vehicles -> System.out.println(vehicles.toString()));
            line=scanner.nextLine();

        }
        List<Vehicles2> cars = allVehicles.stream().filter(vehicles2 -> vehicles2.getType().equals("car")).collect(Collectors.toList());
        List<Vehicles2> trucks = allVehicles.stream().filter(vehicles2 -> vehicles2.getType().equals("truck")).collect(Collectors.toList());


        System.out.printf("Cars have average horsepower of: %.2f.%n" +
                "Trucks have average horsepower of: %.2f.", averageHorsePower(cars),averageHorsePower(trucks));

    }


    private static class Vehicles2 {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicles2(String type, String model, String color, int horsePower) {
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
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                    getType().toUpperCase().charAt(0)+getType().substring(1), getModel(),
                    getColor(), getHorsePower());
        }
    }
    public static double averageHorsePower(List<Vehicles2> vehicles){
        if(vehicles.size()==0){
            return 0.0;
        }
        return vehicles.stream().mapToDouble(Vehicles2::getHorsePower).sum()/vehicles.size();
    }

}