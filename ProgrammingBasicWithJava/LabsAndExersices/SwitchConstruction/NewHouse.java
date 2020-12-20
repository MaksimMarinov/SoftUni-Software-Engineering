import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flower = scanner.nextLine();
        int flowersSum = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double total = 0;
        switch (flower) {
            case ("Roses"):
                if (flowersSum>80){
                    total = flowersSum*5*0.9;
                }else {
                    total = flowersSum*5;
                }
                break;
                case ("Dahlias"):
                if (flowersSum>90){
                    total = flowersSum*3.8*0.85;
                }else {
                    total = flowersSum*3.8;
                }
                break;
                case ("Tulips"):
                    if (flowersSum>80){
                total = flowersSum*2.8*0.85;
                 }else {
            total = flowersSum*2.8;
        }break;

            case ("Narcissus"):
                if (flowersSum<120){
                    total = flowersSum*3*1.15;
                }else {
                    total = flowersSum*3;
                }break;

            case ("Gladiolus"):
                if (flowersSum<80){
                    total = flowersSum*2.5*1.2;
                }else {
                    total = flowersSum*2.5;
                }break;


        }if (budget>=total){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersSum, flower, budget-total);
        } else if (budget<total){
            System.out.printf("Not enough money, you need %.2f leva more.", total-budget);
        }

    }
}
