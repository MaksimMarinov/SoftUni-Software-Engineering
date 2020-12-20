import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int confectioners = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int waffles = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());
        double sumConfectioners = (cakes * 45 + waffles * 5.8 + pancakes * 3.2) * confectioners;
        double finalSum = (sumConfectioners * days)*7/8;
        System.out.printf("%.2f", finalSum);

    }
}
