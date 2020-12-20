import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = Integer.parseInt(scanner.nextLine());
        double others = 0;
        double totalElectricity = 0;
        double totalWater = 0;
        double totalInternet = 0;
        totalWater = months*20;
        totalInternet = months*15;
        double totalOthers = 0;
        double totalAll = 0;
        for (int i = 1; i<=months; i++){
           double electricity =  Double.parseDouble(scanner.nextLine());
           others = (electricity + 20 + 15)*1.2;
           totalElectricity += electricity;

           totalOthers += others;


        }totalAll = totalElectricity+totalInternet+totalOthers+totalWater;
        double average = totalAll/months;
        System.out.printf("Electricity: %.2f lv%n", totalElectricity);
        System.out.printf("Water: %.2f lv%n", totalWater);
        System.out.printf("Internet: %.2f lv%n", totalInternet);
        System.out.printf("Other: %.2f lv%n", totalOthers);
        System.out.printf("Average: %.2f lv", average);

    }
}
