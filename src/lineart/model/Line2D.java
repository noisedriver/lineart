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
        if (displacement.x != 0) {
            // move so that x = 0 if displacement_x != 0
            double b = origin.y + displacement.y / displacement.x * origin.x;
            this.origin = new Point2D(0, b);
        } else {
            // can choose any y-value...
            this.origin = new Point2D(origin.x,0);
        }
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
        // TODO : always with reference to (0,b) ~ y=ax+b or (c,0) ~ x = c
        return this.origin;
    }
    
    @Override
    public Point2D getDisplacement() {
        // TODO : normalize?
        return this.displacement;
    }

    @Override
    public Point2D getPointForX(double x) {
        
        //       |    /     x = c
        //  (0,d)|   /        |
        //  -----|--/-------------------- y = d
        //       | /          |
        //       |/y=ax+b     |
        //       |            |
        //    --/+-----------------------------
        //     / |(0,0)       |(x,0)
        //    /  |            |
        
        if (this.displacement.x == 0) // any Y value if origin.x == x...
            return (this.origin.x == x) ? new Point2D(x,0) : null;
        
        if (this.displacement.y == 0)
            return new Point2D(x, this.origin.y);
        
        double a = displacement.y/displacement.x;
        double y = a * x + origin.y;
        return new Point2D(x, y);
    }

    @Override
    public Point2D getPointForY(double y) {
        if (this.displacement.x == 0) // any Y value if origin.x == x...
            return new Point2D(this.origin.x, y);
        
        if (this.displacement.y == 0)
            return (this.origin.y == y) ? new Point2D(0,y) : null;
        
        double a = displacement.y/displacement.x;
        double x = origin.x + y / a;
        return new Point2D(x, y);
    }

    @Override
    public Position relativePosition(Point2D p0) {
        
        double  x0 = origin.x, y0 = origin.y,
                x1 = origin.x + displacement.x, y1 = origin.y + displacement.y,
                x2 = p0.x, y2 = p0.y;
        
        double value = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        
        if (value > 0) return Position.LEFT;
        if (value < 0) return Position.RIGHT;
        return Position.HIT;
    }
}
