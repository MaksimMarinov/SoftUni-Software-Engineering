import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int magnolies = Integer.parseInt(scanner.nextLine());
        int hyacints  = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactuses = Integer.parseInt(scanner.nextLine());
        double gift = Double.parseDouble(scanner.nextLine());
        double totalFlowers = magnolies * 3.25 + hyacints * 4 + roses * 3.5 + cactuses * 8;
        double totalProfit = totalFlowers * 0.95;
        double moneyLeft = Math.floor(totalProfit - gift);
        double moneyNeeded =  Math.ceil(gift - totalProfit);
        if (totalProfit >= gift) {
            System.out.printf("She is left with %.0f leva. ", moneyLeft);}
        else if (gift > totalProfit) {
            System.out.printf("She will have to borrow %.0f leva.", moneyNeeded);
        }
    }
}
