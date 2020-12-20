import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double priceVacation = 0;
        String location = "";
        String house = "";
        switch (season){
            case ("Summer"):
                location = "Alaska";
                if (budget <= 1000){
                    priceVacation = 0.65 * budget;
                    house = "Camp";
                    System.out.printf("%s - %s - %.2f", location, house, priceVacation );

                }else if (budget > 1000 && budget<= 3000){
                    priceVacation = 0.8 * budget;
                    house = "Hut";
                    System.out.printf("%s - %s - %.2f", location, house, priceVacation );

                }else {
                    priceVacation=0.9*budget;
                    house = "Hotel";
                    System.out.printf("%s - %s - %.2f", location, house, priceVacation );
                }break;
            case ("Winter"):
                location = "Morocco";
                if (budget <= 1000){
                    priceVacation = 0.45 * budget;
                    house = "Camp";
                    System.out.printf("%s - %s - %.2f", location, house, priceVacation );

                }else if (budget > 1000 && budget<= 3000){
                    priceVacation = 0.6 * budget;
                    house = "Hut";
                    System.out.printf("%s - %s - %.2f", location, house, priceVacation );

                }else {
                    priceVacation=0.9*budget;
                    house = "Hotel";
                    System.out.printf("%s - %s - %.2f", location, house, priceVacation );
                }break;

        }
    }
}
