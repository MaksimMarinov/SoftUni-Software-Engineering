import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Scheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(tasks::push);
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
                .forEach(threads::offer);
        int task = Integer.parseInt(bf.readLine());
        int winningThread=0;
        while (true) {
            int currentTask = tasks.peek();
            int currentThread = threads.peek();
            if (currentTask == task) {
                tasks.pop();
                winningThread = currentThread;
                break;
            } else if (currentTask <= currentThread) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", winningThread, task);
        if(!threads.isEmpty()){
            threads.forEach(thread-> System.out.print(thread+" "));
        }
    }
}
