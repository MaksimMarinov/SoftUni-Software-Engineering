import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double depositSum = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        double interestPerYear = depositSum * percent/100;
        double interestPerMonth = interestPerYear/12;
        double sum = depositSum + months * interestPerMonth;
        System.out.println(sum);


    }
}
