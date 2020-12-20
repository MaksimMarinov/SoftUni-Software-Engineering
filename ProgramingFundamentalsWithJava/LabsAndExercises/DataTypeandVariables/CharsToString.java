import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "";
        for (int i = 0; i <3 ; i++) {
            char c = scanner.nextLine().charAt(0);
            word += c;

            
        }
        System.out.println(word);

    }
}
