import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        byte months = Byte.parseByte(scanner.nextLine());
        double moneySaved = 0;
        for (int i = 1; i <= months; i++) {
            if(i%2!=0&&i>1){
                moneySaved-=0.16*moneySaved;
            }else if(i%4==0){
                moneySaved=moneySaved*1.25;
            }
            moneySaved+=budget*0.25;
        }
        if(moneySaved>=budget){
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", moneySaved-budget );
        }else {
            System.out.printf("Sorry. You need %.2flv. more.", budget-moneySaved);
        }
    }
}
