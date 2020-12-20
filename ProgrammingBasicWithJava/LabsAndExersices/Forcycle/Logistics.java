import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine());
        double cargoPerTruck = 0;
        double cargoPerBus = 0;
        double cargoPerTrain = 0;
        int tonPertruck = 0;
        int tonPerTrain = 0;
        int tonPerBus = 0;
        int sumCargo = 0;
        double sumCargoPerVehicle;
        for (int i=1; i<=period; i++) {
            int cargo = Integer.parseInt(scanner.nextLine());
            if (cargo <= 3) {
                cargoPerBus += 200 * cargo;
                tonPerBus += cargo;

            } else if (cargo >= 4 && cargo <= 11) {
                cargoPerTruck += 175 * cargo;
                tonPertruck += cargo;


            } else {
                tonPerTrain += cargo;
                cargoPerTrain += 120*cargo;


            }

            sumCargo += cargo;




        } sumCargoPerVehicle = cargoPerBus + cargoPerTrain + cargoPerTruck;
        System.out.printf("%.2f%n", sumCargoPerVehicle/sumCargo);

        System.out.printf("%.2f%%%n", tonPerBus*1.0/sumCargo*100);
        System.out.printf("%.2f%%%n", tonPertruck*1.0/sumCargo*100);
        System.out.printf("%.2f%%", tonPerTrain*1.0/sumCargo*100);






    }
}
