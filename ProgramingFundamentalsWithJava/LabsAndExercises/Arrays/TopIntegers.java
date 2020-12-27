import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < input.length; i++) {
            int currentNumber = input[i];
            boolean isBigger = true;
            for (int j = i+1; j < input.length; j++) {

                if(currentNumber<=input[j]) {
                    isBigger = false;
                    break;
                }
            }if(isBigger){
                System.out.print(currentNumber+" ");
            }

        }
    }
}
