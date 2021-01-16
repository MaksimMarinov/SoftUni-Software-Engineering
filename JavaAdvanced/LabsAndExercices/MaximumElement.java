import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < numberOfCommands; i++) {
            int[] tokens= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
         switch (tokens[0]){
             case 1:
            numbers.push(tokens[1]);
                 break;
             case 2:
                 numbers.pop();
                 break;
             case 3:
                 System.out.println(Collections.max(numbers));
                 break;
         }
        }
    }
}
