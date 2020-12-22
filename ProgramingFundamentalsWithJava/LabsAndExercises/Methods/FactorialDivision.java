import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne=Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        double result = calculateFactorial(numOne)*1.0/calculateFactorial(numTwo);
        System.out.printf("%.2f", result);
    }
    private static long calculateFactorial(int n){
        long factorial = 1;
        for (int i = 1; i <=n ; i++) {
            factorial *= i;

        }return factorial;
    }
}
