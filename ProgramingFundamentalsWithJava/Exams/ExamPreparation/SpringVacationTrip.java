import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());
        double fuelPerKm = Double.parseDouble(scanner.nextLine());
        double foodExpensesPerPersonPerDay = Double.parseDouble(scanner.nextLine());
        double roomRateForOnePerson = Double.parseDouble(scanner.nextLine());
        double hotelExpenses = days * peopleCount * roomRateForOnePerson;
        double foodExpenses = peopleCount * foodExpensesPerPersonPerDay * days;

        if (peopleCount > 10) {
            hotelExpenses *= 0.75;
        }
        double currentExpenses = hotelExpenses + foodExpenses;
        for (int i = 1; i <= days; i++) {
            if (currentExpenses >= budget) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", currentExpenses - budget);
                return;
            }
            double distancePerDay = Double.parseDouble(scanner.nextLine());
            double fuelPerDay = fuelPerKm * distancePerDay;
            currentExpenses += fuelPerDay;
            if (i % 3 == 0 || i % 5 == 0) {
                currentExpenses += (0.4 * currentExpenses);
            }
            if (i % 7 == 0) {
                currentExpenses -= (currentExpenses / peopleCount);
            }
            if (currentExpenses > budget) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", currentExpenses - budget);
                return;
            }


        }


        System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - currentExpenses);
    }





    }

