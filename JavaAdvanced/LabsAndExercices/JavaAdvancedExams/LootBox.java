import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LootBox {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> first = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(first::offer);
        ArrayDeque<Integer> second = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(second::push);
        int items = 0;
        while (!first.isEmpty()&&!second.isEmpty()){
            int currentFirst = first.peek();
            int currentSecond =second.pop();
            int sum = currentFirst+currentSecond;
            if(isEven(sum)){
                items+=sum;
                first.poll();

            }else{
                first.offer(currentSecond);
            }
        }
        if(first.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if(second.isEmpty()){
            System.out.println("Second lootbox is empty");
        }
        if(items>=100){
            System.out.println("Your loot was epic! Value: "+items);
        }else{
            System.out.println("Your loot was poor... Value: "+items);
        }


    }
    private static boolean isEven(int number){
        return number%2==0;
    }
}
