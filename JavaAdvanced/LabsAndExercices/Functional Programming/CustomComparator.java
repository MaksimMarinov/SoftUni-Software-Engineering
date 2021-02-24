import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Integer> comparator = ((a,b)->{
            if(a%2==0&&b%2!=0) {
                System.out.println(a+" "+b);
                return -1;
            }else if(b%2==0&&a%2!=0) {
                System.out.println(a+" "+b);
                return 1;
            }
            return a.compareTo(b);

        });
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted(comparator).forEach(e-> System.out.print(e+" "));

    }
}

