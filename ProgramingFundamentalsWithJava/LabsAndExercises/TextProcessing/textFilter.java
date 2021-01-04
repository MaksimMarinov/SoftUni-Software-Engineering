import java.util.Scanner;

public class textFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String bannedWord : bannedWords) {
            StringBuilder star = new StringBuilder();
            star.append("*".repeat(bannedWord.length()));
            text=text.replace(bannedWord, star);

        }

        System.out.println(text);

    }

}
