import java.util.Arrays;
import java.util.Scanner;

public class train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            arr[i]=number;
            sum += number;
        }
        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
        System.out.println();
        System.out.println(sum);
    }
}
