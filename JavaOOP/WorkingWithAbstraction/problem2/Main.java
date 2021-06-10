package problem2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine()+":");
        CardRank[] cardRank = CardRank.values();
        for (CardRank rank : cardRank) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.name());
        }
    }
}
