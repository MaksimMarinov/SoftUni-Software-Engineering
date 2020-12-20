import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int i = 0;
        int moneyCharityCash =0;
        int moneyCharityCard =0;
        int moneyCharityAll = 0;
        int moneyCharityCardNum = 0;
        int moneyCharityCashNum =0;
        double moneyCharityCashAvarage =0;
        double moneyCharityCardAvarage =0;
        while (!input.equals("End")){
            int money = Integer.parseInt(input);
            i++;

            if (i%2==0){
                if (money>=10){
                    moneyCharityCard += money;
                    moneyCharityCardNum += 1;
                    System.out.println("Product sold!");
                }else {
                    System.out.println("Error in transaction!");
                }
            }else {
                if (money<=100){
                    moneyCharityCash += money;
                    moneyCharityCashNum += 1;
                    System.out.println("Product sold!");
                }else {
                    System.out.println("Error in transaction!");
                }
            }moneyCharityAll = moneyCharityCash+moneyCharityCard;
            moneyCharityCardAvarage = 1.0*moneyCharityCard/moneyCharityCardNum;
            moneyCharityCashAvarage = 1.0*moneyCharityCash/moneyCharityCashNum;

            if (moneyCharityAll>=sum){
                System.out.printf("Average CS: %.2f%n", moneyCharityCashAvarage );
                System.out.printf("Average CC: %.2f%n", moneyCharityCardAvarage );
                break;}
            input = scanner.nextLine();




        }if (input.equals("End")){
            System.out.println("Failed to collect required money for charity.");
            }
    }
}
