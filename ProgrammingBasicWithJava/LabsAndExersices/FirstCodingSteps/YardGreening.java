import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        double squareMeters = Double.parseDouble (scanner.nextLine());
        double price = squareMeters * 7.61;
        double discount = price * 18 / 100;
        double finalPrice = price - discount;
        System.out.printf("The final price is: %.2f lv.", finalPrice);
        System.out.println();
        System.out.printf("The discount is: %.2f lv.", discount);


    }
}
