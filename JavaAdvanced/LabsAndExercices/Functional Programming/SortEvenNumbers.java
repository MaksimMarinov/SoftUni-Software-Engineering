import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).filter(SortEvenNumbers::isEven).toArray();
        if(numbers.length!=0){
            System.out.println(formatArray(numbers));

            Arrays.sort(numbers);
            System.out.println(formatArray(numbers));
        }


    }
    private static boolean isEven(int number){
        return isDivisibleBy(number);
    }
    private static boolean isDivisibleBy(int number){
        return number % 2 ==0;
    }

    private static String formatArray (int[] numbers) {
       return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }


}
