import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double mackerelPrice = Double.parseDouble(scanner.nextLine());
        double toyPrice = Double.parseDouble(scanner.nextLine());
        double bonitoWeight = Double.parseDouble(scanner.nextLine());
        double safridWeight = Double.parseDouble(scanner.nextLine());
        double musselsWeight = Double.parseDouble(scanner.nextLine());
        double bonitoPrice = 1.6*mackerelPrice;
        double safridPrice = 1.8*toyPrice;
        double totalSum = (bonitoPrice*bonitoWeight) + (safridPrice*safridWeight) + (musselsWeight*7.5);
        System.out.printf("%.2f", totalSum);


    }
}

