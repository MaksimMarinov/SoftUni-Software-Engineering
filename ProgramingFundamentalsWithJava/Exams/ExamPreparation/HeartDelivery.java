import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\@+")).
                mapToInt(e -> Integer.parseInt(e)).toArray();
        String command = scanner.nextLine();
        int indexOfTheCupidLocation = 0;
        while (!command.equals("Love!")){
            String[] jumps = command.split("\\s+");
            int jumpLength = Integer.parseInt(jumps[1]);
            indexOfTheCupidLocation=indexOfTheCupidLocation+jumpLength;
                if (indexOfTheCupidLocation>input.length-1){
                indexOfTheCupidLocation=0;}

                if(input[indexOfTheCupidLocation]>0){
            input[indexOfTheCupidLocation]=input[indexOfTheCupidLocation]-2;
                    if(input[indexOfTheCupidLocation]==0){
                        System.out.printf("Place %d has Valentine's day.%n", indexOfTheCupidLocation);
                    }}
            else{
                System.out.printf("Place %d already had Valentine's day.%n", indexOfTheCupidLocation );
            }
            command=scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n",indexOfTheCupidLocation);
        int countNotVisitedHouses=0;

        for (int i = 0; i <input.length ; i++) {
            if(input[i]>0){
                countNotVisitedHouses++;
            }


        }
        if(countNotVisitedHouses==0){
            System.out.println("Mission was successful.");
        }else{
            System.out.printf("Cupid has failed %d places.", countNotVisitedHouses);
        }
    }

}
