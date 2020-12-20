import java.util.Scanner;

public class GodzillavsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int countStatists = Integer.parseInt(scan.nextLine());
        double priceStatists = Double.parseDouble(scan.nextLine());
        double decor = 0.10 * budget;
        double clothesPrice = countStatists * priceStatists;
        if (countStatists > 150) {
            clothesPrice = clothesPrice * 0.9;

        }
        double totalSum = decor + clothesPrice;
        double difference = Math.abs(totalSum - budget);
        if (budget >= totalSum) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", difference);
        } else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", difference);}








    }
}
