
import java.util.*;


public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> deck = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("JOKER")){
            String[] tokens = command.split(": ");
            String name = tokens[0];
            String[] currentHand = tokens[1].split(", ");
            Set<String> cards = new HashSet<>(Arrays.asList(currentHand));
            if(!deck.containsKey(name)){
                deck.put(name,cards  );

            }else{
                Set<String> currentCards = deck.get(name);
                currentCards.addAll(cards);
                deck.put(name, currentCards);


            }


            command= scanner.nextLine();
        }
        scanner.close();
        deck.forEach((k,v)->{
            System.out.println(k+": " +getSum(v));
        });
    }

    private static int getSum(Set<String> v) {
        int sum=0;
        for (String s : v) {
            int multipliicator=checkForValueOfTheSecondSymbol(s);
            sum=checkForValueOfTheFirstSymbol(sum, s, multipliicator);

        }
        return sum;
    }

    private static int checkForValueOfTheFirstSymbol(int sum, String currentCard,int multiplicator) {
        if(Character.isDigit(currentCard.charAt(0))){
            if(Character.isDigit(currentCard.charAt(1))){
                sum += Integer.parseInt(currentCard.substring(0,2))*multiplicator;
            }else{
                sum += Integer.parseInt(currentCard.substring(0,1))*multiplicator;
            }

        }else if(currentCard.charAt(0)=='J'){
            sum +=11*multiplicator;
        }else if(currentCard.charAt(0)=='Q'){
            sum +=12*multiplicator;
        }else if(currentCard.charAt(0)=='K'){
            sum +=13*multiplicator;
        }else if(currentCard.charAt(0)=='A'){
            sum +=14*multiplicator;
        }
        return sum;
    }
    private static int checkForValueOfTheSecondSymbol(String currentCard) {
        if(Character.isDigit(currentCard.charAt(1))){
            if(currentCard.charAt(2)=='S'){
                return 4;
            }else if(currentCard.charAt(2)=='H'){
                return 3;
            }else if(currentCard.charAt(2)=='D'){
                return 2;
            }else if(currentCard.charAt(2)=='C'){
                return 1;
            }
        }else{
            if(currentCard.charAt(1)=='S'){
                return 4;
            }else if(currentCard.charAt(1)=='H'){
                return 3;
            }else if(currentCard.charAt(1)=='D'){
                return 2;
            }else if(currentCard.charAt(1)=='C'){
                return 1;
            }
        }

       return 1;
    }
}
