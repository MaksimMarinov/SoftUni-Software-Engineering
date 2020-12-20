import java.util.Scanner;

public class coffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int sumDrinks = Integer.parseInt(scanner.nextLine());
        double drinkPrice = 0;
        switch (drink){
            case("Espresso"):
                if (sugar.equals("Without")){
                    drinkPrice = 0.9*sumDrinks*0.65;
                }else if (sugar.equals("Normal")){
                    drinkPrice = sumDrinks;
                }else if (sugar.equals("Extra")){
                    drinkPrice = 1.2*sumDrinks;
                }if (sumDrinks>=5){
                    drinkPrice = drinkPrice*0.75;
            }break;
            case("Cappuccino"):
                if (sugar.equals("Without")){
                    drinkPrice = sumDrinks*0.65;
                }else if (sugar.equals("Normal")){
                    drinkPrice =1.2* sumDrinks;
                }else if (sugar.equals("Extra")){
                    drinkPrice = 1.6*sumDrinks;
                }
                break;
            case("Tea"):
                if (sugar.equals("Without")){
                    drinkPrice = 0.5*sumDrinks*0.65;
                }else if (sugar.equals("Normal")){
                    drinkPrice =0.6* sumDrinks;
                }else if (sugar.equals("Extra")){
                    drinkPrice = 0.7*sumDrinks;
                }
                break;

        }if (drinkPrice>15){
            drinkPrice = drinkPrice*0.8;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", sumDrinks, drink, drinkPrice);

    }
}
