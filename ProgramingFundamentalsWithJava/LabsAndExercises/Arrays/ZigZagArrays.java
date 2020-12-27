import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(e -> Integer.parseInt(e)).toArray();
            if(i%2==0){
                arr1[i] = input[0];
                arr2[i] = input[1];
            }else{
                arr2[i] = input[0];
                arr1[i] = input[1];
            }

        }
       Arrays.stream(arr1).forEach(e-> System.out.print(e+" "));
        System.out.println();
       Arrays.stream(arr2).forEach(e-> System.out.print(e+" "));
    }
}
