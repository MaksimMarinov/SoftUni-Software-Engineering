import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int oddsSum = 0;
        int evenSum = 0;
        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum +=currentNumber;


            } else {
                oddsSum +=currentNumber;







        }}if (evenSum==oddsSum) {
            System.out.println("Yes");
            System.out.println("Sum = " + evenSum);
        } else {
            int diff = Math.abs(oddsSum - evenSum);
            System.out.println("No");
            System.out.println("Diff = " + diff);
        }
    }
}



