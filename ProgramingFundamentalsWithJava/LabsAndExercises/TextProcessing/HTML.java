package com.company;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        System.out.printf("<h1>%n    %s%n</h1>%n", line1);
        String line2 = scanner.nextLine();
        System.out.printf("<article>%n    %s%n</article>%n", line2);
        String lineCom = scanner.nextLine();
        while (!lineCom.equals("end of comments")){
                System.out.printf("<div>%n    %s%n</div>%n", lineCom);
                lineCom= scanner.nextLine();
        }
    }
}
