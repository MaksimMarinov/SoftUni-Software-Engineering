import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        printTribonacci(n);
    }

    private static void printTribonacci(int n) {
        int tribo1 = 1;
        int tribo2 = 1;
        int tribo3 = 2;
        int triboN = 1;
        if(n!=1&&n!=2){
            System.out.print(tribo1 + " " + tribo2 + " " + tribo3 + " ");
            for (int i = 3; i < n; i++) {

                triboN=tribo1+tribo2+tribo3;
                tribo1=tribo2;
                tribo2=tribo3;
                tribo3=triboN;


                System.out.print(triboN + " ");

            }
        }else{
            for (int i = 1; i <=n ; i++) {
                System.out.print(tribo1 + " ");
                tribo1=tribo2;
                tribo2=tribo3;



            }
        }

    }
}
