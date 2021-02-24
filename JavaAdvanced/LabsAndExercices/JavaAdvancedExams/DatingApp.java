import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(males::push);
        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(females::offer);
        int matches = 0;
        while (!males.isEmpty()&&!females.isEmpty()){
            int currentMale = males.peek();
            int currentFemale = females.peek();
            if(currentMale<=0||currentFemale<=0){
                if(currentMale<=0){
                    males.pop();
                }
                if(currentFemale<=0){
                    females.poll();
                }
                continue;
            }
            if(currentFemale%25==0){
                females.poll();
                females.poll();
                continue;
            }
            if(currentMale%25==0){
                males.pop();
                males.pop();
                continue;
            }
            if(currentFemale==currentMale){
                matches++;
                females.poll();
                males.pop();

            }else{
                females.poll();
                males.push(males.pop()-2);
            }


        }
        System.out.println("Matches: "+matches);
        String out = "Males left: ";
        print(males, out);
        out = "Females left: ";
        print(females, out);



    }

    private static void print(ArrayDeque<Integer> gender, String out) {
        if(gender.isEmpty()){
            System.out.println(out+"none");
        }else {
            List<String> outList = gender.stream().map(String::valueOf).collect(Collectors.toList());
            out+=String.join(", ", outList);
            System.out.println(out);
        }
    }
}