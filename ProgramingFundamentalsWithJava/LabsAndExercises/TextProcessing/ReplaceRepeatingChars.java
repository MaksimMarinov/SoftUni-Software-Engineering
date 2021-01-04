package com.company;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char previous = input.charAt(0);
        sb.append(previous);
        for (int i = 1; i <input.length() ; i++) {
        char currentChar = input.charAt(i);
            if(previous!=currentChar){
                sb.append(currentChar);
                previous=currentChar;

            }
        }
        System.out.print(sb);
    }
}
