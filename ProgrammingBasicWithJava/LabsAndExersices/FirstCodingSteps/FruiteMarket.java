import java.util.Scanner;

public class FruiteMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double strawberryPrice = Double.parseDouble(scanner.nextLine());
        double bananaWeight = Double.parseDouble(scanner.nextLine());
        double orangesWeight = Double.parseDouble(scanner.nextLine());
        double raspberriesWeight = Double.parseDouble(scanner.nextLine());
        double strawberryWeight = Double.parseDouble(scanner.nextLine());
        double raspberriesPrice = strawberryPrice * 0.5;
        double orangesPrice = raspberriesPrice * 0.6;
        double bananasPrice = raspberriesPrice * 0.2;
        double total = strawberryPrice * strawberryWeight + bananasPrice * bananaWeight + orangesPrice * orangesWeight + raspberriesPrice * raspberriesWeight;
        System.out.printf("%.2f", total);


    }
}
