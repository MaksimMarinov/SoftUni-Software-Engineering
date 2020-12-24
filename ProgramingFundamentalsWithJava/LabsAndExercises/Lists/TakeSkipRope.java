import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());
        List<Integer> numbers = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        String inputString = "";
        for (int i = 0; i <input.size() ; i++) {
            inputString += input.get(i);
        }


        for (int i = 0; i < input.size(); i++) {
            char symbol = inputString.charAt(i);
            boolean isDigit = Character.isDigit(symbol);
            if (isDigit) {
                numbers.add((Integer.parseInt(String.valueOf(symbol))));

            } else {
                String letter = Character.toString(symbol);
                letters.add(letter);
            }
        }
String output = "";
        for (int i = 0; i <numbers.size() ; i++) {
            int indexForAction = numbers.get(i);
            if(indexForAction>letters.size()){
                indexForAction=letters.size();
            }
            if(i%2==0){
                output += addLetters(indexForAction,letters);

            }
            letters=removeLetters(indexForAction,letters);
            
        }
        System.out.println(output);


    }
    private static String addLetters(int index, List<String> letters){
        String output ="";
        for (int i = 0; i < index ; i++) {
            output+=letters.get(i);
        }return output;
    }
    private static List<String> removeLetters(int index, List<String> letters){
        for (int i = 0; i < index ; i++) {
            letters.remove(0);

        }return letters;
    }
}
