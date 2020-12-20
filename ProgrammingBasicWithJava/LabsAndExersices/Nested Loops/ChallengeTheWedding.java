import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char sector = scanner.nextLine().charAt(0);
        int rows = Integer.parseInt(scanner.nextLine());
        int seats = Integer.parseInt(scanner.nextLine());

        int factor = 0;
        int counter = 0;

        for (char i = 'A'; i <= sector; i++, rows++) {
            for (int j = 1; j <= rows; j++) {
                if (j % 2 == 0){
                factor =  j;}
                for (char k = 'a'; k < 'a' + seats + factor; k++) {
                    System.out.printf("%c%d%c%n", i, j, k);
                    counter++;
                }
            }
        }

        System.out.printf("%d", counter);
    }
}