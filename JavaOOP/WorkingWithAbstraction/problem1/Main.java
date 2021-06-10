package problem1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        CardSuit[] cardSuit = CardSuit.values();
        System.out.println(command+":");
        for (CardSuit suit : cardSuit) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}
