import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] children = scanner.nextLine().split(" ");
            int n = Integer.parseInt(scanner.nextLine());
            ArrayDeque<String> queue = new ArrayDeque<>();
            int cycle =1;
            Collections.addAll(queue,children);
            while (queue.size()>1){
                for (int i = 1; i < n; i++) {
                    queue.offer(queue.poll());
                }
               String name = queue.peek();
                if(!isPrime(cycle)){
                    System.out.println("Removed "+name);
                    queue.poll();
            }else{
                    System.out.println("Prime "+name);

                }

            cycle++;

        }
            System.out.println("Last is "+queue.poll());
    }

    private static boolean isPrime(int cycle) {
            if(cycle==1){
                return false;
            }
        for (int i = 2; i < cycle; i++) {
            if(cycle%i==0){
                return false;
            }
        }return true;
    }

}
