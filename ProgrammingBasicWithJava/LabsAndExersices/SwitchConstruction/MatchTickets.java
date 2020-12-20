import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());
        double transport = 0;
        double ticket = 0;
        switch (category) {
            case ("VIP"):
                ticket = 499.99;
                break;

            case ("Normal"):
                ticket = 249.99;
                break;
        }
        if (people >= 1 && people <= 4) {
            transport = 0.75 * budget;
        } else if (people >= 5 && people <= 9) {
            transport = 0.6 * budget;
        } else if (people >= 10 && people <= 24) {
            transport = 0.5 * budget;
        } else if (people >= 25 && people <= 49) {
            transport = 0.4 * budget;
        } else if (people >= 50) {
            transport = 0.25 * budget;
        }
        double money = transport + people * ticket;
        double difference = Math.abs(budget - money);
        if (budget >= money) {
            System.out.printf("Yes! You have %.2f leva left.", difference);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", difference);

        }
    }
}

