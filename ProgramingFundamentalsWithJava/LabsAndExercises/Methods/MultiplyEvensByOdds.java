import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        int number = Math.abs(new Scanner(System.in).nextInt());
        System.out.println(getMultipleOfEvensAndOdds(number));


    }

    private static int getMultipleOfEvensAndOdds(int number) {

        return getSumEvenDigits(number) * getSumOddDigits(number);

    }

    private static int getSumEvenDigits(int number) {

        int sumEvenDigits = 0;


        for (int i = 0; number > 0; i++) {
            int nextDigit = number%10;
            number /=10;
            if (nextDigit%2==0){
                sumEvenDigits+=nextDigit;
            }
        }return (sumEvenDigits);


    }
    private static int getSumOddDigits(int number) {

        int sumOddDigits = 0;


        for (int i = 0; number > 0; i++) {
            int nextDigit = number%10;
            number /=10;
            if (nextDigit%2!=0){
                sumOddDigits+=nextDigit;
            }
        }return (sumOddDigits);


    }


}


