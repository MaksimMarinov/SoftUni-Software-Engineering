import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class addVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> vatAdder = val->val*1.20;
        String values =Arrays.stream(scanner.nextLine().split(", ")).
                map(e->
                        String.format("%.2f", vatAdder.apply(Double.parseDouble(e))))
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println("Prices with VAT:");
        System.out.println(values);
    }
}
