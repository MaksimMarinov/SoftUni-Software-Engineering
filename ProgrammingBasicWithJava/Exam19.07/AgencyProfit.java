import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int ticketsAdults = Integer.parseInt(scanner.nextLine());
        int ticketsChd = Integer.parseInt(scanner.nextLine());
      double ticketPriceAdl = Double.parseDouble(scanner.nextLine());
      double serviceFee = Double.parseDouble(scanner.nextLine());
      double ticketPriceChd = ticketPriceAdl*0.3;
      double totalProfit = 0.2*(ticketsAdults*(ticketPriceAdl+serviceFee) + ticketsChd*(ticketPriceChd + serviceFee));
        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", name, totalProfit);


    }
}
