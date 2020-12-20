import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=n ; i++) {

            char input = scanner.nextLine().charAt(0);
            input = (char)(input+key);
            System.out.print(input);

        }

    }
}
