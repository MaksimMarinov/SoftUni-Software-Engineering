package com.company;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        for (int i = 0; i < words.length; i++) {
            String repeatedWord = repeat(words[i], words[i].length());
            System.out.print(String.join("", repeatedWord));

        }

    }

    private static String repeat(String word, int count) {
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i]=word;

        }
        return String.join("", repeatArr);


    }
}
