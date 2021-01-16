import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> plantsPesticide = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(plantsPesticide::push);
       int countDays = 0;
       scanner.close();

       while (true){
           countDays++;
           boolean isDie = false;
           for (int i = 1; i < numberOfPlants; i++) {
               int currentPlant = plantsPesticide.pop();
               int leftPlant=plantsPesticide.peek();
               if(currentPlant>leftPlant){
                   isDie=true;
               }else {
                   plantsPesticide.push(currentPlant);
               }
           }
           if(!isDie){
               break;
           }
       }
        System.out.println(countDays);

    }
}
