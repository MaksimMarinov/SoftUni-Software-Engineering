import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            first.add(scanner.nextInt());
        }
        for (int i = 0; i<m; i++){
            second.add(scanner.nextInt());
        }
        first.retainAll(second);
        first.forEach(number-> System.out.print(number+" "));
    }
}
