package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String text = scanner.nextLine();
        int nextIndex= text.indexOf(key);
        while (nextIndex!=-1){
            text=text.replace(key,"");
            nextIndex=text.indexOf(key);

        }

        System.out.println(text);

    }
}
