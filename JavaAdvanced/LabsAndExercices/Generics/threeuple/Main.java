package threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        Threeuple<String, String, String> address = new Threeuple<>(name, tokens[2], tokens[3]);
        tokens = scanner.nextLine().split("\\s+");
        boolean isDrunk;
        if(tokens[2].equals("drunk")){
            isDrunk=true;
        }else{
            isDrunk=false;
        }
        Threeuple<String, Integer, Boolean> beer =
                new Threeuple<>(tokens[0], Integer.parseInt(tokens[1]), isDrunk );
        tokens = scanner.nextLine().split("\\s+");
        Threeuple<String, Double, String> balance =
                new Threeuple<>(tokens[0], Double.parseDouble(tokens[1]), tokens[2] );
        System.out.printf("%s%n%s%n%s", address, beer, balance);
    }
}
