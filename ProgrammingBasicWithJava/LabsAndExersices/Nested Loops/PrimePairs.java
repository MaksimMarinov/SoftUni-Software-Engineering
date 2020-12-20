import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1=Integer.parseInt(scanner.nextLine());
        int number2=Integer.parseInt(scanner.nextLine());
        int n1=Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        for (int i = number1; i<=number1+n1; i++){

            for(int l=number2; l<=number2+n2;l++){
                if (number1%i!=0 && number2%l!=0){
                    System.out.printf("%d%d%n", i, l);
                }





            }

        }
    }
}
