package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String nameOfCard = scanner.nextLine();
       String suitOfCard= scanner.nextLine();
       int powerOfCard = CardRank.valueOf(nameOfCard).getValue();
     int powerOfSuit = CardSuit.valueOf(suitOfCard).getValue();
        System.out.printf("Card name: %s of %s; Card power: %d", nameOfCard, suitOfCard, powerOfCard+powerOfSuit);


    }
}
