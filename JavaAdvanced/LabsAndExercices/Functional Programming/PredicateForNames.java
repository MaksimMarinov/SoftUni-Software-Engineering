import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLength = Integer.parseInt(scanner.nextLine());
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(name -> name.length() <= maxLength).forEach(System.out::println);
    }
}
