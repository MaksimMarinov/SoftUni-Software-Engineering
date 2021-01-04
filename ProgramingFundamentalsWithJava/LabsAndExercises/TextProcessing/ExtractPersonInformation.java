package com.company;
import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String name = line.substring(line.indexOf('@') + 1, line.indexOf('|'));
            String age = line.substring(line.indexOf('#')+1, line.indexOf('*'));
            System.out.printf("%s is %s years old.%n", name, age);

        }
    }
}
