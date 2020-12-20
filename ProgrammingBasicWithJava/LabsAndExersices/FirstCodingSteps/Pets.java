import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int foodLeft = Integer.parseInt(scanner.nextLine());
        double foodForDogPerDay = Double.parseDouble(scanner.nextLine());
        double foodForCatPerDay = Double.parseDouble(scanner.nextLine());
        double foodForTurtlePerDay = Double.parseDouble(scanner.nextLine());
        double foodTotal = days * foodForDogPerDay + days * foodForCatPerDay + (days * foodForTurtlePerDay / 1000);
        double foodRemains = Math.floor(foodLeft - foodTotal);
        double foodNeeded = Math.ceil(foodTotal - foodLeft);
        if (foodLeft >= foodTotal) {
            System.out.printf("%.0f kilos of food left.", Math.abs(foodRemains));}
        else if (foodLeft < foodTotal) {
            System.out.printf("%.0f more kilos of food are needed.", Math.abs(foodNeeded));}
        }

    }

