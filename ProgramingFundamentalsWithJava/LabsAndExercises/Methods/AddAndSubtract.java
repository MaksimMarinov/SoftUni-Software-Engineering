import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int one = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        System.out.println(sum(one,second,third));

    }

    private static int sum(int one, int second, int third) {
       int total = one+second-third;
        return total;

    }
}
