import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> numbersInfo = new LinkedHashMap<>();
       Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble)
                .forEach(e->{
                    numbersInfo.putIfAbsent(e, 0);
                    numbersInfo.put(e, numbersInfo.get(e)+1);
                });


        numbersInfo.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
