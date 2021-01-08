import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int playersCount = Integer.parseInt(scanner.nextLine());
        double energyLeft = Double.parseDouble(scanner.nextLine());
        double waterTotal = Double.parseDouble(scanner.nextLine())*playersCount*days;
        double foodTotal = Double.parseDouble(scanner.nextLine())*playersCount*days;
        for (int realDays = 1; realDays <= days; realDays++) {

double energyLost = Double.parseDouble(scanner.nextLine());
            energyLeft-=energyLost;
            if(energyLeft<=0){
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",foodTotal, waterTotal);
                return;
            }
            if(realDays%2==0){
                energyLeft+=(0.05*energyLeft);
                waterTotal-=(waterTotal*0.3);

            }if(realDays%3==0){
                energyLeft+=(0.1*energyLeft);
                foodTotal=foodTotal-(foodTotal/playersCount);
            }



        }
        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energyLeft);


    }

}
