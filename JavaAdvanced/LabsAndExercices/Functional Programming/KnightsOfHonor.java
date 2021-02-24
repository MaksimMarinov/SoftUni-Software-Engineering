import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> addSir = word-> System.out.println("Sir "+word);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(addSir);
    }
}
