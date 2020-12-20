import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double luggagePrice = Double.parseDouble(scanner.nextLine());
        double luggageWeight = Double.parseDouble(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int luggageCount = Integer.parseInt(scanner.nextLine());
        double totalLuggagePrice = 0;
        if (luggageWeight<10){
            luggagePrice = luggagePrice*0.2;
        }else if (luggageWeight>=10 && luggageWeight<=20){
            luggagePrice = luggagePrice/2;
        }
        if (days>30){
            luggagePrice = 1.1*luggagePrice;
        }else if (days<=30 && days>=7){
            luggagePrice = 1.15*luggagePrice;
        }else if (days<7) {
            luggagePrice = 1.4*luggagePrice;

        }
        totalLuggagePrice= luggagePrice*luggageCount;
        System.out.printf("The total price of bags is: %.2f lv.", totalLuggagePrice);



    }
}
