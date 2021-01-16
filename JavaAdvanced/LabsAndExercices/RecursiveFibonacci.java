import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        int cycle = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i<=cycle; i++){
            long sum=0;
            long lastIndex = 0;
            if(i<=1){
                long toAdd=1;
                fibonacci.push(toAdd);
            }else if(i==2){
                fibonacci.push(fibonacci.peek()+fibonacci.pop());
            } else{
               lastIndex=fibonacci.pop();
               sum=lastIndex+fibonacci.pop();
                fibonacci.push(lastIndex);
                fibonacci.push(sum);


            }

        }
        System.out.println(fibonacci.pop());
    }
}
