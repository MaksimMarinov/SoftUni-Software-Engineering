import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
       double x2 = Double.parseDouble(scanner.nextLine());
       double y2 = Double.parseDouble(scanner.nextLine());
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        double lineOneLength = FindLongerLine(x1, y1, x2, y2);
        double lineTwoLength = FindLongerLine(x3, y3, x4, y4);
        if (lineOneLength >= lineTwoLength)
        {
            double pointOneToCent = FindClosestPoint(x1, y1);
            double pointTwoToCent = FindClosestPoint(x2, y2);

            if (pointOneToCent <= pointTwoToCent)
            {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
            }
            else
            {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
            }
        }else{
            double pointOneToCent = FindClosestPoint(x3, y3);
            double pointTwoToCent = FindClosestPoint(x4, y4);

            if (pointOneToCent <= pointTwoToCent)
            {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)",x3, y3, x4, y4);
            }
            else
            {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)",x4, y4, x3, y3);
            }

        }


    }
    static double FindLongerLine(double x1, double y1, double x2, double y2)
    {
        double result = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
        return result;
    }

    static double FindClosestPoint(double coordinateX1, double coordinateY1)
    {
        double distancePointToCent = Math.sqrt(Math.pow(coordinateX1, 2) + Math.pow(coordinateY1, 2));
        return distancePointToCent;
    }
}





