import java.util.Scanner;

public class poolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPeople = Integer.parseInt(scanner.nextLine());
        double entryFee = Double.parseDouble(scanner.nextLine());
        double priceSunbed  = Double.parseDouble(scanner.nextLine());
        double priceUmbrella = Double.parseDouble(scanner.nextLine());
        double sunbedsNumber = Math.ceil(0.75*numberPeople);
        double umbrellasNumber = Math.ceil(numberPeople*0.5);
        double result = (numberPeople*entryFee) + (sunbedsNumber*priceSunbed) + (umbrellasNumber * priceUmbrella);
        System.out.printf("%.2f lv.", result);

    }
}
