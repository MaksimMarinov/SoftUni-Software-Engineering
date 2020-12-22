import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());

        System.out.printf(new DecimalFormat("0.####").format(result(n1,n2)));


    }
    static double result(double n1, double n2){
       return Math.pow(n1,n2);
    }
}
