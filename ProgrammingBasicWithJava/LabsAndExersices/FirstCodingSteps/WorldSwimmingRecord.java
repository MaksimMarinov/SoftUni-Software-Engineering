import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeInSeconds = Double.parseDouble(scanner.nextLine());
        double slow = Math.floor(distance / 15) * 12.5;
        double totalTime = distance * timeInSeconds + slow;
        double difference = Math.abs(record - totalTime);
        if (record > totalTime) {
            System.out.printf(" Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else if (record <= totalTime) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", difference);
        }
    }
}
