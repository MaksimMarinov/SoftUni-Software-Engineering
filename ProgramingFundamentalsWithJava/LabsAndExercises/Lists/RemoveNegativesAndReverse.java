import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
              .map(Integer::parseInt).collect(Collectors.toList())  ;

        List<Integer> nonNegativeNumbers = new ArrayList<>();
        for (int number : numbers) {
            if(number>=0){
                nonNegativeNumbers.add(number);

            }
            
        }
        if(nonNegativeNumbers.isEmpty()){
            System.out.println("empty");
        }
        Collections.reverse(nonNegativeNumbers);
        for (Integer nonNegativeNumber : nonNegativeNumbers ) {
            System.out.print(nonNegativeNumber + " ");
            
        }
        

    }
    private static List<Integer> parseLineOfNumbers(Scanner scanner) {
        String line = scanner.nextLine();
        String[] array = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s : array) {
            int number = Integer.parseInt(s);
            numbers.add(number);


        }return numbers;
    }
}
