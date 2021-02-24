import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FlowerWreaths {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   ArrayDeque<Integer> lilies = new ArrayDeque<>();
   Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(lilies::push);
   ArrayDeque<Integer> roses = new ArrayDeque<>();
   Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(roses::offer);
   int flowersLeft = 0;
   int wreathsCount =0;
   while (!lilies.isEmpty()&&!roses.isEmpty()){
       int currentRose = roses.poll();
       int currentLilia =  lilies.pop();;
       int sum = currentLilia+currentRose;
       if(sum==15){

           wreathsCount++;
       }else if(sum>15){
           lilies.push(currentLilia-2);
           roses.offer(currentRose);
       }else{
           flowersLeft+=sum;
       }
   }
   if(flowersLeft>15){
       int moreWreaths = flowersLeft/15;
       wreathsCount+=moreWreaths;
   }
   if(wreathsCount>=5){
       System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCount);
   }else{
       System.out.printf("You didn't make it, you need %d wreaths more!", 5-wreathsCount);
   }


    }
}
