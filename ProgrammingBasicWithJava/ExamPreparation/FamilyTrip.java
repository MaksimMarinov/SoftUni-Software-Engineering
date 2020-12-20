import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double pricePerNight = Double.parseDouble(scanner.nextLine());
        int extraCostPercent = Integer.parseInt(scanner.nextLine());
        if (nights>7){
            pricePerNight = pricePerNight*0.95;
        }
        double total = nights*pricePerNight+extraCostPercent*budget/100;
        if (budget>=total){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget-total);
        }else {
            System.out.printf("%.2f leva needed.", total-budget);
        }


        
    }
}
