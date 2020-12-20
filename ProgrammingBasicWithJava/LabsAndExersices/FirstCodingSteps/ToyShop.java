import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double excursionPrice = Double.parseDouble(scanner.nextLine());
        int puzzlesQuantity = Integer.parseInt(scanner.nextLine());
        int dollsQuantity = Integer.parseInt(scanner.nextLine());
        int bearsQuantity = Integer.parseInt(scanner.nextLine());
        int minionsQuantity = Integer.parseInt(scanner.nextLine());
        int trucksQuantity = Integer.parseInt(scanner.nextLine());
        double puzzlesSum = puzzlesQuantity * 2.6;
        int dollsSum = dollsQuantity * 3;
        double bearsSum = bearsQuantity * 4.1;
        double minionsSum = minionsQuantity * 8.2;
        int trucksSum = trucksQuantity * 2;
        double toysSumProfit = puzzlesSum + dollsSum + bearsSum + minionsSum + trucksSum;
        int toysQuantity = puzzlesQuantity + bearsQuantity + dollsQuantity + minionsQuantity + trucksQuantity;
        if (toysQuantity < 50) {
            double profit = toysSumProfit - (0.1 * toysSumProfit);
            double differencePositive = profit -  excursionPrice;
            double differenceNegative = excursionPrice - profit;
            if (profit >= excursionPrice) {
                System.out.printf("Yes! " + "%.2f"  + " lv left.", differencePositive);
            } else if (profit < excursionPrice) {
                System.out.printf("Not enough money! " + "%.2f" + " lv needed.", differenceNegative);


            }

        }
        if (toysQuantity >= 50) {
            double profit = 0.75 * toysSumProfit - (0.1 * (toysSumProfit * 0.75));
            double differencePositive = profit -  excursionPrice;
            double differenceNegative = excursionPrice - profit;
            if (profit >= excursionPrice) {
                System.out.printf("Yes! " + "%.2f" + " lv left.", differencePositive);
            } else if (profit < excursionPrice) {
                System.out.printf("Not enough money! " + "%.2f" + " lv needed.", differenceNegative);


            }
        }
    }
}

