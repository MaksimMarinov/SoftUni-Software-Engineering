import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        for (int i = 1; i <=number ; i++) {
            int sum = 0;
            int num = i;
            for (int j = 0; j <Integer.toString(i).length(); j++) {
                sum += num%10;
                num/=10;
                
            }

            if (sum ==5 || sum ==7 || sum ==11)
            {
                System.out.println(i + " -> True");
            }
            else
            {
                System.out.println(i + " -> False");
            }

        }



    }
}
