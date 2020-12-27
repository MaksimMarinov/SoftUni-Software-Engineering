import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String firstNumber = input[0];
            for (int j = 0; j < input.length-1; j++) {
                input[j] = input[j+1];

            }
            input[input.length-1]=firstNumber;
        }
        Arrays.stream(input).forEach(e-> System.out.print(e+" "));

    }

}
