import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);
        int result = 0;
        while (stack.size()==0){
            int number1 = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int number2 = Integer.parseInt(stack.pop());

            switch (op){
                case "+":
                    result=number1+number2;
                    break;
                case"-":
                    result=number1-number2;
                    break;

            }
            stack.push(String.valueOf(result));
        }System.out.println(result);

    }
}
