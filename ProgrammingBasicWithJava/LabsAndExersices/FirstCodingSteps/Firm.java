import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hoursNeeded = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int employees = Integer.parseInt(scanner.nextLine());
        double hoursForWork = 0.9 * days * 8;
        double extraordinaryWork = employees * 2 * days;
        double hoursSum = Math.floor(hoursForWork + extraordinaryWork);
        double hoursLeft = Math.abs(hoursSum - hoursNeeded);
        if (hoursSum >= hoursNeeded) {
            System.out.printf("Yes!%.0f hours left.", hoursLeft);}
        else if (hoursSum < hoursNeeded ) {
            System.out.printf("Not enough time!%.0f hours needed.", hoursLeft);
        }

    }
}
