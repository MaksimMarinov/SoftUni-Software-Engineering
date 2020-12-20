import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1111; i<10000; i++ ){
            int firstDigit = i/1000;
            int secondDigit = i/100%10;
            int thirdDigit = i/10%10;
            int forthDigit = i%10;
            boolean check1 = firstDigit != 0 && n%firstDigit==0;
            boolean check2 = secondDigit != 0 && n%secondDigit==0;
            boolean check3 = thirdDigit != 0 && n%thirdDigit == 0;
            boolean check4 = forthDigit !=0 && n%forthDigit == 0;
            if (check1 && check2 & check3 & check4){
                System.out.print(i + " ");
            }

        }
    }
}
