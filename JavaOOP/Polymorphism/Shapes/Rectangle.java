package Shapes;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    protected double calculatePerimeter() {
        return this.height*2+this.width*2;

    }

    @Override
    protected double calculateArea() {
        return this.height*this.width;
    }
}
