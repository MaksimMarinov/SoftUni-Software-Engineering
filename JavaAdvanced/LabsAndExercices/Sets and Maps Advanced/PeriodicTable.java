import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueElements = new TreeSet<>();
        while (counter-->0){
            String[] elements = scanner.nextLine().split("\\s+");
            uniqueElements.addAll(Arrays.asList(elements));
        }
        uniqueElements.forEach(element-> System.out.print(element+" "));
    }
}
