package tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens=scanner.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        String address = tokens[2];
        Tuple<String, String> tuple = new Tuple<>(name, address);
        tokens=scanner.nextLine().split("\\s+");
        name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        Tuple<String, Integer> tuple1 = new Tuple<>(name, liters);
        tokens=scanner.nextLine().split("\\s+");
       int number = Integer.parseInt(tokens[0]);
       double number2 = Double.parseDouble(tokens[1]);
       Tuple<Integer, Double> tuple2 = new Tuple<>(number, number2);
        System.out.println(tuple);
        System.out.println(tuple1);
        System.out.println(tuple2);


    }
}
