import java.util.Arrays;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] arrayTimeFirst = new int[input.length/2];
        int[] arrayTimeSecond = new int[input.length/2];
        int count=0;
        for (int i = 0; i < input.length/2 ; i++) {
            arrayTimeFirst[i] = input[i];
        }
        for (int i = input.length-1; i >input.length/2 ; i--) {
            arrayTimeSecond[count] = input[i];
            count++;

        }
        double totalTimeFirst = totalTime(arrayTimeFirst);
        double totalTimeSecond =totalTime(arrayTimeSecond);
        if(totalTimeFirst<totalTimeSecond){
            System.out.printf("The winner is left with total time: %.1f", totalTimeFirst);
        }else if(totalTimeFirst>totalTimeSecond){
            System.out.printf("The winner is right with total time: %.1f", totalTimeSecond);}


    }
    public static double totalTime(int[] array){
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            int currentTime = array[i];
            if(currentTime==0){
                sum = 0.8*sum;
            }else{
                sum +=currentTime;
            }
        }return sum;
    }
}
