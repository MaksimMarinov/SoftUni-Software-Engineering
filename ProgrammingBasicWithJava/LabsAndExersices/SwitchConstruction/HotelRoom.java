import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double apartment = 0;
        double studio = 0;
        switch (month){
            case ("May"):
            case ("October"):
                if (nights > 7&& nights <= 14){
                  studio = 50 * 0.95;
                   apartment = 65*1.0;
                }else if (nights > 14){
                   studio = 0.7*50;
                   apartment=0.9*65;
                }else {
                   studio = 50;
                     apartment = 65;
                }break;

            case ("June"):
            case ("September"):
                if (nights > 14){
                   studio = 0.8*75.2;
                    apartment=0.9*68.7;
                }else {
                    studio = 75.2;
                     apartment = 68.7;}
                break;

            case ("July"):
            case ("August"):
                studio = 76;
                if (nights > 14){
                    apartment=0.9*77;
                }else {
                     apartment = 77;}
                break;



        }
        System.out.printf("Apartment: %.2f lv.", apartment * nights);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", studio * nights);


    }
}
