import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> words = new LinkedHashMap<>();
        String[] line = scanner.nextLine().split(" ");
        for (String s : line) {
            String wordToLowerCase = s.toLowerCase();
            if(!words.containsKey(wordToLowerCase)){
                words.put(wordToLowerCase,1);
            }else{
                words.put(wordToLowerCase, words.get(wordToLowerCase)+1);
            }


        }
        ArrayList<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: words.entrySet()){
            if(entry.getValue()%2!=0){
                odds.add(entry.getKey());
            }

        }
        for (int i = 0; i <odds.size() ; i++) {
            System.out.print(odds.get(i));
            if(i<odds.size()-1){
                System.out.print(", ");}

        }
    }
}
