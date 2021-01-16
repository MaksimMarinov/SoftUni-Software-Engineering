import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersToPush = scanner.nextInt();
        int numbersToPop = scanner.nextInt();
        int numberToCheck = scanner.nextInt();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < numbersToPush; i++) {
            numbers.push(scanner.nextInt());
        }
        for (int i = 0; i < numbersToPop; i++) {
            numbers.pop();
        }
        if(numbers.size()==0){
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
