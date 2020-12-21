import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountCharsInaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String text = scanner.nextLine();
       Map<Character,Integer> occ = new TreeMap<>();
       for (char s:text.toCharArray()){
           if(s!=' '){
               if(!occ.containsKey(s)){
                   occ.put(s,1);
               }else{
                   occ.put(s,occ.get(s)+1);
               }
           }
       }
        for (Map.Entry<Character, Integer> characterIntegerEntry : occ.entrySet()) {
            System.out.println(characterIntegerEntry.getKey()+" -> "+characterIntegerEntry.getValue());
        }
    }
}
