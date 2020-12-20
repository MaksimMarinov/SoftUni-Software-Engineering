import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottlesNum = Integer.parseInt(scanner.nextLine());
        int detergent = bottlesNum*750;
        int dishes = 0;
        int pot = 0;
        int detergentLeftAD = 0;
        int detergentLeftAP = 0;
        int i =0 ;
        int detTotal = 0;
        int detForWash = 0;

        while (true){
            String command = scanner.nextLine();
            if (command.equals("End")){

                break;
            }
            int num = Integer.parseInt(command);
            i++;
            if (detTotal< detForWash){

                break;}

            if (i%3 == 0){

                pot += num;
                detergentLeftAP += num;
            }else {
                dishes += num;
                detergentLeftAD += num;
            } detForWash = (detergentLeftAD*5+detergentLeftAP*15);
            detTotal=detergent- detForWash;

        }
        if (detTotal>detForWash){
            System.out.println("Detergent was enough!");
        System.out.printf("%d dishes and %d pots were washed.%n", dishes, pot);
        System.out.printf("Leftover detergent %d ml.", detTotal);}
        else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(detTotal-detForWash));
        }

    }
}
