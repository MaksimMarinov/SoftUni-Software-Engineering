import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();
        if (figure.equals("square")) {
            double squareSide = Double.parseDouble(scanner.nextLine());
            double areaSquare = squareSide * squareSide;
            System.out.printf("%.3f", areaSquare);
        } else if (figure.equals("rectangle")) {
            double rectangleSide1 = Double.parseDouble(scanner.nextLine());
            double rectangleSide2 = Double.parseDouble(scanner.nextLine());
            double areaRectangle = rectangleSide1 * rectangleSide2;
            System.out.printf("%.3f", areaRectangle);
        } else if (figure.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            double areaCircle = Math.PI * radius * radius;
            System.out.printf("%.3f", areaCircle);
        } else if (figure.equals("triangle")) {
            double triangleSide = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            double areaTriangle = triangleSide * height / 2;
            System.out.printf("%.3f", areaTriangle);
        }
    }
}





