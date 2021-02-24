import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiFunction<String, Integer, Integer> arithmetic = (command, number) -> {
            switch (command) {
                case "add":
                    return (number + 1);
                case "multiply":
                    return number * 2;
                case "subtract":
                    return number - 1;
                default:
                    throw new IllegalStateException("Unknown format type");
            }
        };
        Consumer<Integer> print = number -> System.out.print(number + " ");
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.equals("print")) {
                Arrays.stream(numbers).forEach(print::accept);
                System.out.println();
            } else {
                String finalCommand = command;
                numbers = Arrays.stream(numbers).map(number -> arithmetic.apply(finalCommand, number)).toArray();
            }
            command = scanner.nextLine();

        }
    }
}
