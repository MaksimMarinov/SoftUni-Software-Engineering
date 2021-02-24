package GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        while (n-->0){
            box.getElements().add(scanner.nextLine());
        }
        int count =box.countElementsGrater(scanner.nextLine(),box.getElements());
        System.out.println(count);
    }
}
