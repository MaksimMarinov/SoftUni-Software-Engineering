import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numbersAsStrings =  line.split(" ");
        int [] numbers = new int[numbersAsStrings.length];
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        for (int number : numbers) {
            if (number%2==0){
                evenSum += number;
            }else {
                oddSum += number;
            }

        }
        int diff = evenSum-oddSum;
        System.out.println(diff);
    }
}
