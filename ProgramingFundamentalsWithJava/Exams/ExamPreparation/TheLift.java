import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < input.length; i++) {
            int freeSeats = 4 - input[i];
            if (freeSeats > 0) {
                if (people > freeSeats) {
                    people -= freeSeats;
                    input[i] = 4;
                }else if(people==freeSeats){
                    people=0;
                    input[i]=4;
                    break;
                }else{
                    input[i]+=people;
                    people=0;
                    break;
                }
            }
        }
        int freeSeats=0;
        for (int i = 0; i < input.length; i++) {
            freeSeats+=(4-input[i]);
        }
        if(people<=0&&freeSeats>0){
            System.out.println("The lift has empty spots!");
        }else if(people>0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }
        for (int i : input) {
            System.out.print(i+" ");

        }

    }
}
