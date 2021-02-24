import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lastNumber = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Predicate<Integer> number = n->{
            for (int j : numbers) {
                if(j==0){
                   continue;
                }
                if (n % j != 0) {
                    return false;
                }
            }
            return true;
        };
        IntStream.range(1, lastNumber+1).filter(number::test)
                .forEach(e-> System.out.print(e+" "));
    }
}
