package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    Box<String> box = new Box();
    while (n-->0){
        box.getElements().add(scanner.nextLine());
    }
    int index1 = scanner.nextInt();
    int index2 = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        box.swapElements(index1, index2);
        System.out.println(box);
    }

 }
