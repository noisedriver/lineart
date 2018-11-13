package lineart.model;

/**
 *
 * @author Joris
 */
public class Rectangle /*implements IPolygon*/ {
    
    final double width;
    final double height;
    final Point2D origin;

    public Rectangle() {
        this(0, 0);
    }
    
    public Rectangle(double width, double height) {
        this(width, height, new Point2D());
    }
    
    public Rectangle(double width, double height, Point2D point) {
        this.width = width;
        this.height = height;
        this.origin = point;
    }
    
    //@Override
    public boolean contains(Point2D point) {
        double x = point.x, y = point.y,
        x1 = this.origin.x,
        y1 = this.origin.y,
        x2 = this.origin.x + this.width,
        y2 = this.origin.y + this.height; // diagonal
        assert(x1 < x2 && y1 < y2);
        return (x >= x1 && x <= x2) && (y >= y1 && y <= y2);
    }
}
