package lineart.model;

/**
 *
 * @author Joris
 */
public class Point2D {
    
    public final double x;
    public final double y;
    
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point2D() {
        this(0,0);
    }
}
