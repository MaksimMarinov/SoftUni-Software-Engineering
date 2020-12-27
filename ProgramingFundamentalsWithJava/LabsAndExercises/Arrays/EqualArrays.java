import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstArraysString = scanner.nextLine();
        String[] firstNumbersStrings = firstArraysString.split(" ");
        int[] firstArray = new int[firstNumbersStrings.length];
        int sum = 0;
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(firstNumbersStrings[i]);

        }
        String secondArraysString = scanner.nextLine();
        String[] secondNumbersStrings = secondArraysString.split(" ");
        int[] secondArray = new int[secondNumbersStrings.length];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Integer.parseInt(secondNumbersStrings[i]);

        }boolean equal = true;
        int differentAtIndex = -1;
        if (firstArray.length==secondArray.length){
            for (int i = 0; i < firstArray.length; i++) {
                if(firstArray[i]!=secondArray[i]){
                    equal = false;
                    differentAtIndex = i;
                    break;

                }
            }

        }else {
            equal = false;
        }if (equal){
            for (int number: firstArray) {
                sum+=number;
            }
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }else {

            System.out.printf("Arrays are not identical. Found difference at %d index.",differentAtIndex );

        }

    }
}
