import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int juniorBikers = Integer.parseInt(scanner.nextLine());
        int seniorBikers = Integer.parseInt(scanner.nextLine());
        String trace = scanner.nextLine();
        double taxJunior = 0;
        double taxSenior = 0;
        switch (trace){
            case ("trail"):
                taxJunior = 5.5;
                taxSenior = 7;
                break;
            case ("cross-country"):
                taxJunior = 8;
                taxSenior = 9.5;
                if(juniorBikers+seniorBikers >= 50){
                    taxJunior = 8*0.75;
                    taxSenior = 9.5*0.75;
                }
                break;
            case ("downhill"):
                taxJunior = 12.25;
                taxSenior = 13.75;
                break;
            case ("road"):
                taxJunior = 20;
                taxSenior = 21.5;
                break;




        }double costs = 0.05 * (taxJunior*juniorBikers+taxSenior*seniorBikers);
        double totalIncome = (taxJunior*juniorBikers+taxSenior*seniorBikers) - costs;
        System.out.printf("%.2f",totalIncome);

    }
}
