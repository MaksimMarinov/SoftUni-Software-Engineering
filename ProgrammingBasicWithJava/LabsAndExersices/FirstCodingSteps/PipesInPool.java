import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());
        double water = p1 * hours + p2 * hours;
        double percentFullPool = water/v* 100;
        double percentP1 = (p1*hours / water) * 100;
        double percentP2 = (p2 *hours/ water) * 100;
        if (water <= v) {
            System.out.printf("The pool is  %.2f%% full. Pipe 1: %.2f%% + . Pipe 2: %.2f%%.",
                    (percentFullPool),
                    (percentP1),
                    (percentP2));
        } else {
            System.out.printf("For %.2f%% the pool overflows with %f litres", hours, water - v);


        }
    }
}
