import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class forMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 1; i < numbers.size()-1 ; i++) {
            numbers.set(i, numbers.get(i)+numbers.get(numbers.size()-1));

        }
        numbers.set(numbers.get(numbers.size()-1), numbers.get(0));
        int numberToRemove = numbers.get(numbers.size()-1);
        System.out.println(numberToRemove);
    }

    private static void listPrint(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int numbersToPrint = numbers.get(i);
            System.out.print(numbersToPrint + " ");
        }
    }
}
