import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>, Integer> findSmallest = numbers->{
            int min = numbers.stream().min(Integer::compareTo).get();
            return numbers.lastIndexOf(min);
        };
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        System.out.println(findSmallest.apply(numbers));

    }
}
