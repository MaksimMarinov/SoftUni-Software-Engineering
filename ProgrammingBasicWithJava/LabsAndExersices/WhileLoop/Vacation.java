import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyNeeded = Double.parseDouble(scanner.nextLine());
        double moneyHave = Double.parseDouble(scanner.nextLine());
        int daysSpend = 0;
        int daysAll = 0;

        while (true) {
            String input = scanner.nextLine();
            double sum = Double.parseDouble(scanner.nextLine());
            daysAll++;
            switch (input) {

                case ("spend"):
                    daysSpend += 1;
                    moneyHave -= sum;
                    if (sum > moneyHave) {
                        moneyHave = 0;


                    }


                    break;
                case ("save"):
                    moneyHave += sum;
                    daysSpend = 0;
                    break;


            }if (moneyNeeded <= moneyHave) {
                System.out.printf("You saved the money for %d days.", daysAll);
                break;

        }if (daysSpend >= 5) {
                System.out.println("You can't save the money.");
                System.out.println(daysSpend);
                break;
            }

        }
    }
}
