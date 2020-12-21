import java.util.*;


public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     Arrays.stream(scanner.nextLine().split(" "))
             .map(Integer::parseInt)
             .sorted(Comparator.reverseOrder()).limit(3).forEach(i->System.out.printf("%d ",i));


    }
}
