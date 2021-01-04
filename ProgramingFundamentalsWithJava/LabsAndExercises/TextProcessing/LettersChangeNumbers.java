package com.company;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        double sum =0;
        for (String token : tokens) {
            char firstLetter = token.charAt(0);
            char secondLetter = token.charAt(token.length()-1);
            double number = Double.parseDouble(token.substring(1, token.length()-1));
            int firstLetterPositon = getLetterAlphabeticPosition(firstLetter);
            int secondLetterPositon = getLetterAlphabeticPosition(secondLetter);
            if(Character.isUpperCase(firstLetter)){
                sum+=number/firstLetterPositon;
            }else{
                sum+=number*firstLetterPositon;
            }
            if(Character.isUpperCase(secondLetter)){
                sum-=secondLetterPositon;
            }else{
                sum+=secondLetterPositon;
            }




        }
        System.out.printf("%.2f",sum);
    }
    private static int getLetterAlphabeticPosition(char c){
char targetChar = Character.toLowerCase(c);
char initialChar = 'a';
int position=targetChar-initialChar+1;
        return (position);
    }
}
