import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int joineryCount = Integer.parseInt(scanner.nextLine());
        String size = scanner.nextLine();
        String delivery = scanner.nextLine();
        double totalValue = 0;
        if (joineryCount <=10){
            System.out.println("Invalid order");
        }else {
            switch (size){
                case("90X130"):
                    if (joineryCount>30 && joineryCount<=60){
                        totalValue = joineryCount*110*0.95;
                    }else if (joineryCount>60){
                        totalValue = joineryCount*110*0.92;
                    }else {
                        totalValue = joineryCount*110;
                    }break;
                case("100X150"):
                    if (joineryCount>40 && joineryCount<=80){
                        totalValue = joineryCount*140*0.94;
                    }else if (joineryCount>80){
                        totalValue = joineryCount*140*0.90;
                    }else {
                        totalValue = joineryCount*140;
                    }break;
                case("130X180"):
                    if (joineryCount>20 && joineryCount<=50){
                        totalValue = joineryCount*190*0.93;
                    }else if (joineryCount>50){
                        totalValue = joineryCount*190*0.88;
                    }else {
                        totalValue = joineryCount*190;
                    }break;
                case("200X300"):
                    if (joineryCount>25 && joineryCount<=50){
                        totalValue = joineryCount*250*0.91;
                    }else if (joineryCount>50){
                        totalValue = joineryCount*250*0.86;
                    }else {
                        totalValue = joineryCount*250;
                    }break;

            }
            if (delivery.equals("With delivery")){
                totalValue = totalValue+60;
            }else {
                totalValue = totalValue;
            }
            if (joineryCount>99){
                totalValue = 0.96*totalValue;
            }
            System.out.printf("%.2f BGN", totalValue);
        }
    }
}
