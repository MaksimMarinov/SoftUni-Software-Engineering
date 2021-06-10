package Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    protected abstract double calculatePerimeter();
    protected abstract double calculateArea();

}
