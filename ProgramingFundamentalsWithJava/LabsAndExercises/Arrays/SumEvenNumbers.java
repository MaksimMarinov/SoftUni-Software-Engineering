import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numberAsStrings = line.split(" ");
        int[] array = new int[numberAsStrings.length];
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            array[i] = Integer.parseInt(numberAsStrings[i]);
            if (array[i]%2 ==0 ){
                sum+=array[i];
            }


        }


        System.out.println(sum);


    }
}
