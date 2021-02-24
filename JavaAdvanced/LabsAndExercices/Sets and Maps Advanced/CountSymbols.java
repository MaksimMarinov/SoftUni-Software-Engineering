import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        Map<Character, Integer> charsInfo = new TreeMap<>();
        for (char c : input) {
            charsInfo.putIfAbsent(c, 0);
            charsInfo.put(c, charsInfo.get(c) + 1);
        }
        charsInfo.forEach((k,v)-> System.out.printf("%c: %d time/s%n", k, v));

    }
}
