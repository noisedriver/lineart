package lineart.model;

/**
 *
 * @author noisedriver
 */
public class LineSegment2D {
    
    private final Point2D point1;
    private final Point2D point2;
    
    public LineSegment2D(Point2D point1, Point2D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    
    public Point2D getPoint1() {
        return this.point1;
    }
    
    public Point2D getPoint2() {
        return this.point2;
    }
    
    public Rectangle getBoundingBox() {
        return new Rectangle(this.point2.x - this.point1.x, this.point2.y - this.point1.y, point1);
    }
    
    // https://stackoverflow.com/questions/16314069/calculation-of-intersections-between-line-segments
    public Point2D getIntersection(LineSegment2D line) {
        Point2D p1  = line.point1, p2  = line.point2, _p1 = this.point1, _p2 = this.point2;
        double  x1 =  p1.x, y1 =  p1.y,
                x2 =  p2.x, y2 =  p2.y,
                x3 = _p1.x, y3 = _p1.y,
                x4 = _p2.x, y4 = _p2.y;
        
        double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        // Lines are parallel.
        if (denom == 0.0) return null;
        
        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
        double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
        if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
            // Get the intersection point.
            return new Point2D((x1 + ua*(x2 - x1)), (y1 + ua*(y2 - y1)));
        }
        return null;
        //if (getBoundingBox().contains(p)) return p;
        //return p;
    }
}
