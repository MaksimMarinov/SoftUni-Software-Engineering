import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyHeritage = Double.parseDouble(scanner.nextLine());
        int yearToLive = Integer.parseInt(scanner.nextLine());
        int yearsOld = 17;
        for (int year = 1800; year<=yearToLive; year++){
            if (year%2==0){
                moneyHeritage = moneyHeritage - 12000;

            }else{
                yearsOld = yearsOld+2;
                moneyHeritage = moneyHeritage - (12000+(50*yearsOld));
            }

        }
        if (moneyHeritage>=0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", moneyHeritage);
        }else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(moneyHeritage));

        }

    }
}
