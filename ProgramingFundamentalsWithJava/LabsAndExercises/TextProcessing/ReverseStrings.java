package com.company;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command= scanner.nextLine();
        while (!command.equals("end")){
            String reversed = reverse(command);
            System.out.println(command + " = "+ reversed);
            command= scanner.nextLine();

        }

    }

    private static String reverse(String command) {
        StringBuilder reversed= new StringBuilder();
        int index=command.length()-1;
        for (int i = 0; i < command.length(); i++) {

            reversed.append(command.charAt(index));
            index-=1;
        }
        return String.join("", reversed.toString());

    }
}
