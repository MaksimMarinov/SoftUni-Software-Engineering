import java.util.*;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> numbers = new ArrayDeque<>();
       Arrays.stream(scanner.nextLine().split("\\s+")).forEach(numbers::push);
       numbers.forEach(e-> System.out.print(e+" "));
    }
}
