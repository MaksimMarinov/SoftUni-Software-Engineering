package geometry;

public class Rectangle {
    private Point2D bottomLeft;
    private Point2D topRight;

    public Rectangle(Point2D bottomLeft, Point2D bottomRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = bottomRight;
    }
    public boolean contains(Point2D point){
        return point.isGreaterOrEqualByX(bottomLeft)
                &&point.isGreaterOrEqualByY(bottomLeft)
                &&point.isLessOrEqualByX(topRight)
                &&point.isLessOrEqualByY(topRight);
    }




}
