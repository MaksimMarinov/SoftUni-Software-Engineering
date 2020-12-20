import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vegPrice = Double.parseDouble(scanner.nextLine());
        double fruitPrice = Double.parseDouble(scanner.nextLine());
        int vegWeight = Integer.parseInt(scanner.nextLine());
        int fruitWeight = Integer.parseInt(scanner.nextLine());
        double income = ((vegPrice*vegWeight) + (fruitPrice*fruitWeight))/1.94;
        System.out.printf("%.2f", income);

    }
}
