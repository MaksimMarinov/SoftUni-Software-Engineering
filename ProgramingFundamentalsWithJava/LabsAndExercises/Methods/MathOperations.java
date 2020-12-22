import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = Double.parseDouble(scanner.nextLine());
        char ch = scanner.nextLine().charAt(0);
        double n2 = Double.parseDouble(scanner.nextLine());
        System.out.printf("%.0f", calculations(n1, ch, n2));

    }

    private static double calculations(double n1, char ch, double n2) {
        double result = 0.00;
        switch(ch){
            case ('*'):
                result = n1*n2;
                break;
            case ('+'):
                result=n1+n2;
                break;
            case('-'):
                result=n1-n2;
                break;
            case('/'):
                result=n1/n2;
                break;

        }
        return (result);
    }
}
