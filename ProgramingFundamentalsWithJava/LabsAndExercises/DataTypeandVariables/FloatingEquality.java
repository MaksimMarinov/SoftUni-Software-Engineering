import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());
        double diff = Math.abs(n1-n2);
        if (diff>0.000001 ){
            System.out.println("False");
        }else {
            System.out.println("True");
        }
    }
}
