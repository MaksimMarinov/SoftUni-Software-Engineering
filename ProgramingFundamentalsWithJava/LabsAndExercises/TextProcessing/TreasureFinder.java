package com.company;

import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyNumbers= scanner.nextLine();
        String line = scanner.nextLine();
        while(!line.equals("find")){
            StringBuilder newString= new StringBuilder();
            int keyIndex = 0;

            for (int i = 0; i <line.length() ; i++) {
                    if(keyIndex>=keyNumbers.length()){
                        keyIndex=0;
                    }
                    int key = Integer.parseInt(String.valueOf((keyNumbers.charAt(keyIndex))));
                    int charIndex = line.charAt(i);
                  char newChar = (char) (charIndex - key);
                    newString.append(newChar);
                    keyIndex+=2;
                }


            int indexTreasureStart = newString.indexOf("&");
            int indexTreasureEnd = newString.lastIndexOf("&");
            String treasure = newString.substring(indexTreasureStart+1,indexTreasureEnd);
            int startIndexCoo=newString.indexOf("<")+1;
            int lastIndexCoo=newString.indexOf(">");
            String coordinates =newString.substring(startIndexCoo,lastIndexCoo);
            System.out.printf("Found %s at %s%n", treasure, coordinates);
            line= scanner.nextLine();
        }

    }
}
