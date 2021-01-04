package com.company;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");
        for (String username : usernames) {
            if(validateUserName(username)){
                System.out.println(username);
            }
            
        }

    }
    private static boolean validateUserName(String username){
        if(username.length()<3||username.length()>16){
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char symbol = username.charAt(i);
            if(!Character.isLetter(symbol)&&!Character.isDigit(symbol)&& symbol!='_'&&symbol!='-'){
                return false;
            }

        }return true;
    }
}
