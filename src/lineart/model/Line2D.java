package lineart.model;


//import java.awt.Point;
//import java.awt.geom.Line2D;

/**
 *
 * @author Joris
 */
public class Line2D implements ILine2D {
    
    // Vector of 2 points :
    final Point2D origin;
    final Point2D displacement;
    
    public Line2D(Point2D displacement, Point2D origin) {
        this.displacement = displacement;
        this.origin = origin;
    }
    
    public Line2D(Point2D displacement) {
        assert(displacement.x != 0 || displacement.y != 0);
        this.displacement = displacement;
        this.origin = new Point2D(0,0);
    }

    @Override
    public Point2D getIntersection(ILine2D other) {
        
        double  x1 = this.getOrigin().x,        y1 = this.getOrigin().y,
                x2 = this.getDisplacement().x,  y2 = this.getDisplacement().y,
                // second line...
                x3 = other.getOrigin().x,       y3 = other.getOrigin().y,
                x4 = other.getDisplacement().x, y4 = other.getDisplacement().y;
        
        if (x2 == x1)
            if (y2 == y1) return this.origin;
            else return new Point2D();
        
        // slope
        double a = (y2 - y1) / (x2 - x1);
        double b = 0;
        
        double c = (y2 - y1) / (x2 - x1);
        double d = 0;
        
        // ax + b = y  <--> cx + d = y
        // x' = (d-b)/(a-c); y' = c(x') + d
        double x = (d - b) / (a - c);
        double y = a * x + b;
        
        //return new Point2D(x,y);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean isOnLine(Point2D point) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Point2D getOrigin() {
        return this.origin;
    }
    
    @Override
    public Point2D getDisplacement() {
        return this.displacement;
    }
}
