import java.util.Scanner;

public class NumbersN1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        for (int n = i; i>=1; i--){
            System.out.println(i);
        }
    }
}
