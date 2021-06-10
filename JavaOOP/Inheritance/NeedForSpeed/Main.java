package NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(45, 20);
        System.out.println(raceMotorcycle.getFuelConsumption());
        raceMotorcycle.drive(5);
        System.out.println(raceMotorcycle.getFuel());
    }
}
