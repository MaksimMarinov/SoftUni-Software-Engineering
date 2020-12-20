import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        for (int digit1 = number1; digit1<=number2; digit1++){
            for (int digit2 = number1; digit2<=number2; digit2++){
                for (int digit3 = number1; digit3<=number2; digit3++){
                    for (int digit4 = number1; digit4<=number2; digit4++){
                        if (digit1%2==0 && digit4%2==1 || digit4%2==0 && digit1%2==1){
                            if ( digit1>digit4 && (digit2+digit3)%2==0){
                                System.out.printf("%d%d%d%d ", digit1, digit2, digit3, digit4);}
                        }


                    }


                }

            }


        }
    }
}
