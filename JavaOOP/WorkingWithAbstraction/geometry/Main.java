package geometry;

import IOUtils.ConsoleReader;
import IOUtils.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleReader consoleReader =  new ConsoleReader();
       int[] rectangleInfo = InputParser.parseArray(consoleReader.readLine(), "\\s+");
        Rectangle rectangle = GeometryFactory.createRectangle(rectangleInfo);
        int number = Integer.parseInt(consoleReader.readLine());
        while (number-->0){
            int[] pointInfo = InputParser.parseArray(consoleReader.readLine(), "\\s+");
            Point2D point2D = GeometryFactory.createPoint(pointInfo );
            System.out.println(rectangle.contains(point2D));
        }

    }
}
