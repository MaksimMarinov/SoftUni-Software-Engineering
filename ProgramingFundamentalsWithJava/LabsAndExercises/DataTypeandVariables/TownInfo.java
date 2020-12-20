import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String town = scanner.nextLine();
        long pop = Long.parseLong(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        System.out.printf("Town %s has population of %d and area %d square km.", town, pop, size );


    }
}
