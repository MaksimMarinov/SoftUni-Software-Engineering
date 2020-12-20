import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumA = 0;
        int sumB = 0;
        int diff = 0;
        boolean check = true;
        for (int i =1; i <= n; i++){
            int numA = Integer.parseInt(scanner.nextLine());
            int numB = Integer.parseInt(scanner.nextLine());
            if ( i % 2 !=0){
                sumA = numA+numB;
            }else {
                sumB = numA+numB;
            } if (sumA == sumB || n<2){
                check = true;
            } else {
                diff = Math.abs(sumA-sumB);
                check = false;
            }

        }if (check){
            System.out.printf("Yes, value=%d", sumA);
        } else {
            System.out.printf("No, maxdiff=%d", diff);
        }
    }
}
