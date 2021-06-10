package geometry;

public class GeometryFactory {
    public static Rectangle createRectangle(int[] points){
        return new Rectangle(createPoint(points[0], points[1]), createPoint(points[2],points[3] ));
    }
    public static Point2D createPoint(int x, int y){
        return new Point2D(x, y);
    }
    public static Point2D createPoint(int[] pointsInfo){
        if(pointsInfo.length!=2){
            throw new IllegalStateException("Point can be created only by X and Y coordinates.");
        }
        return createPoint(pointsInfo[0], pointsInfo[1] );
    }
}
