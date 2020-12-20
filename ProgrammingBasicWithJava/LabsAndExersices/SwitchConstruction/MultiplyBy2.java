import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        while (num<0){
            System.out.println("Negative number!");

            num=Double.parseDouble(scanner.nextLine());
        }
        System.out.printf("Result: %.2f", +num*2);



    }
}
