import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(e -> Integer.parseInt(e)).toArray();
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < input.length; j++) {
                sumLeft = sumLeft(j, input);
                sumRight = sumRight(j, input);
                if(sumLeft==sumRight){
                    System.out.println(j);
                    return;
                }
            }
        }
        if(input.length==1){
            System.out.println(0);
        }else{
            System.out.println("no");
        }
    }
    private static int sumLeft (int index, int[] input ){
        int sum=0;
        for (int i = 0; i <index; i++) {
            sum+=input[i];
        }
        return sum;
    }
    private static int sumRight (int index, int[] input ){
        int sum=0;
        for (int i = input.length-1; i >index; i--) {
            sum+=input[i];
        }
        return sum;
    }
}
