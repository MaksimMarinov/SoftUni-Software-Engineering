import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int mSum = 0;
        while (mSum < n)
        {
            int m = Integer.parseInt(scanner.nextLine());
            mSum += m;
        }
        System.out.println(mSum);


    }
}
