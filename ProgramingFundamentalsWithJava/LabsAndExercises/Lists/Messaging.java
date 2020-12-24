import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<String> message = Arrays.stream(scanner.nextLine().split(""))
               .collect(Collectors.toList());
        for (int i = 0; i <numbers.size() ; i++) {
            int currentIndex = numbers.get(i);
            int index = CalculateIndex(currentIndex);
            if(index>message.size()){
                index=index-message.size();
            }
            String letter = GetLetter(index, message);
            System.out.print(letter);
            message.remove(letter);


        }

    }

    private static String GetLetter(int index, List<String> message) {
       int count = 0;
        for (int i = 0; i <index ; i++) {
            count++;
            if(count==message.size()){
                count=0;
            }

        }String currentLetter = message.get(count);
        return currentLetter;

    }

    private static int CalculateIndex(int currentIndex) {
        int index = 0;
        for (int i = 0; i <currentIndex ; i++) {
           int currentNumber = currentIndex%10;
           index +=currentNumber;
           currentIndex /=10;



        }
        return index;
    }


}
