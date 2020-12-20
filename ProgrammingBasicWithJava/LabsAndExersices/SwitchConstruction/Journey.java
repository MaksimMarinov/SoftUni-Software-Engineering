import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = "";
        double rate = 0;
        String house = "0";
        switch(season) {
            case ("winter"):
                house = "Hotel";
                if (budget <= 100) {
                    destination = "Bulgaria";
                    rate = 0.7 * budget;
                } else if (budget > 100 && budget <= 1000) {
                    rate = 0.8 * budget;
                    destination = "Balkans";
                } else {
                    destination = "Europe";
                    rate = 0.9 * budget;
                    house = "Hotel";
                }
                break;
            case ("summer"):
                house = "Camp";
                if (budget <= 100) {
                    destination = "Bulgaria";
                    rate = 0.3 * budget;
                } else if (budget > 100 && budget <= 1000) {
                    rate = 0.4 * budget;
                    destination = "Balkans";
                } else {
                    destination = "Europe";
                    rate = 0.9 * budget;
                    house = "Hotel";
                }
                break;
        } System.out.printf("Somewhere in %s", destination);
        System.out.println();
        System.out.printf("%s - %.2f", house, rate);

        }
    }
