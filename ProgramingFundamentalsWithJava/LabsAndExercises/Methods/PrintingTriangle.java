import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <=n ; i++) {
printNumbers(i);
            
        }
        for (int i = n-1; i >=1; i--) {
            printNumbers(i);

        }
        

    }

    private static void printNumbers(int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            System.out.print(i);
            if(i<maxNumber){
                System.out.print(" ");

            }

            
        }System.out.println();


    }
}
