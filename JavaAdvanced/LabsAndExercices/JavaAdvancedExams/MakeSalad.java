import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class MakeSalad {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> vegetables = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split("\\s+")).forEach(vegetables::offer);
        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(calories::push);
        while (!vegetables.isEmpty()&&!calories.isEmpty()){
            int currentCal = calories.peek();
            while (currentCal>0&&!vegetables.isEmpty()){
                currentCal-=findCalorieFormVeg(vegetables.poll());

            }
            System.out.print(calories.pop()+" ");

        }
        System.out.println();
        if(!vegetables.isEmpty()){
            vegetables.forEach(v->System.out.print(v+" "));

        }else if(!calories.isEmpty()){
            calories.forEach(v->System.out.print(v+" "));
        }
    }

    private static int findCalorieFormVeg(String vegName) {
        switch (vegName){
            case"tomato":
                return 80;

            case "potato":
                return 215;
            case "carrot":
                return 136;
            case"lettuce":
                return 109;
        }
        return 0;
    }
}
