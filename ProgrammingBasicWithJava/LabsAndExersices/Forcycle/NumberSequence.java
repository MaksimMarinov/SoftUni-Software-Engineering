import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n;i++){
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber < min){
                min = currentNumber;
            }if (currentNumber>max){
                max = currentNumber;
            }
        }
        System.out.println("Max number: "+max);
        System.out.println("Min number: "+min);

    }
}
