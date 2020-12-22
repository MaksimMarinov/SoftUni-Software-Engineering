import java.awt.*;
import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double lenght = Double.parseDouble(scanner.nextLine());
        double area = getArea(width,lenght);
        System.out.printf("%.0f", area);

    }

    private static double getArea(double width, double lenght) {
        return width*lenght;
    }
}
