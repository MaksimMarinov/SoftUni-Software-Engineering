import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberToInput = scanner.nextInt();
        int numberToPoll = scanner.nextInt();
        int numberToCheck = scanner.nextInt();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < numberToInput; i++) {
            numbers.offer(scanner.nextInt());
        }
        for (int i = 0; i<numberToPoll; i++){
            numbers.poll();
        }
        if(numbers.isEmpty()){
            System.out.println(0);
        }else{
            if(numbers.contains(numberToCheck)){
                System.out.println(true);
            }else{
                System.out.println(Collections.min(numbers));
            }
        }
    }
}
