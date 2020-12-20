import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget  = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());
        double rent = 0;
        switch (season) {
            case ("Summer"):
            case ("Autumn"):
                rent = 4200;
                break;
            case ("Winter"):
                rent = 2600;
                break;
            case ("Spring"):
                rent = 3000;
                break;
        }if (fishermen <=6){
            rent = rent * 0.9;}
            else if (fishermen>7 && fishermen <= 11){
                rent = rent * 0.85;}
            else if (fishermen > 12){
                rent = rent * 0.75;}
                if (fishermen % 2 == 0 && !season.equals("Autumn")){
                    rent=rent*0.95;}
       if (budget >= rent){
           System.out.printf("Yes! You have %.2f leva left.", budget - rent);}
       else if (rent > budget){
           System.out.printf("Not enough money! You need %.2f leva.", rent - budget);


        }
    }
}
