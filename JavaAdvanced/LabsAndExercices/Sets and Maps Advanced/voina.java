
import java.util.*;
import java.util.stream.Collectors;

public class voina {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck= Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
       int rounds =50;
       while (rounds-->0&&!firstDeck.isEmpty()&&!secondDeck.isEmpty()){
           Integer firstCard = firstDeck.iterator().next();
           Integer secondCard = secondDeck.iterator().next();
           firstDeck.remove(firstCard);
           secondDeck.remove(secondCard);
           if(firstCard>secondCard){
               firstDeck.add(firstCard);
               firstDeck.add(secondCard);
           }else if(secondCard>firstCard){
               secondDeck.add(firstCard);
               secondDeck.add(secondCard);
           }
       }
       if(firstDeck.size()>secondDeck.size()){
           System.out.println("First player win!");
       }else if(secondDeck.size()>firstDeck.size()){
           System.out.println("Second player win!");
       }

    }


}
