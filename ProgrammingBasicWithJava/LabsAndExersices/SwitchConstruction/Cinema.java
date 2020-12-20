import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        double result = rows *  columns;
        switch (movie) {
            case ("Premiere"):
                System.out.printf("%.2f", result*12);
                break;
            case ("Normal"):
                System.out.printf("%.2f", result * 7.5);
                break;
            case("Discount"):
                System.out.printf("%.2f", result * 5);
                break;



        }


    }
}
