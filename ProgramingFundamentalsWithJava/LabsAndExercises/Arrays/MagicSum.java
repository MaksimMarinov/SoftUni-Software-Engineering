import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j < input.length; j++) {
                if(input[i]+input[j]==sum){
                    System.out.println(input[i] + " " +input[j]);
                }
            }
        }

    }
}
