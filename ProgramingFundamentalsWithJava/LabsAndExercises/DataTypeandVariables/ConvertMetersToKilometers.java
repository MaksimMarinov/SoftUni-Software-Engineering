import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sm = Double.parseDouble(scanner.nextLine());
        double m = sm/1000;
        System.out.printf("%.2f", m);

    }
}
