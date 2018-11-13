package lineart.model;

import java.util.Objects;


/**
 *
 * @author noisedriver
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
        
        double a, b, c, d;
        
        // b = y  <--> cx + d = y
        if (this.displacement.x == 0) {
            return other.getPointForY(this.getOrigin().y);
        }
        
        if (other.getDisplacement().x == 0) {
            return this.getPointForY(other.getOrigin().y);
        }
        
        // slope
        a = this.displacement.y / this.displacement.x;
        b = this.getPointForX(0).y;
        
        c = other.getDisplacement().y / other.getDisplacement().x;
        d = other.getPointForX(0).y;
        
        if (a == c) {
            if (b == d) return new Point2D(0, b);
            else return null;
        }
        
        // ax + b = y  <--> cx + d = y
        //
        //      ax + b = cx + d
        // <=>
        //      (a - c)x = b + d
        // <=>
        //      x = (b + d) / (a - c)
        // ==>
        //      y = a (b + d) / (a - c) + b
        //      y = c (b + d) / (a - c) + d
        //
        // x' = (d+b)/(a-c); y' = c(x') + d
        double x = (d + b) / (a - c);
        double y = a * x + b;
        
        return new Point2D(x,y);
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
        //    ---|--/-------------------- y = d
        //       | /          |
        //       |/y=ax+b     |
        //       |            |
        //  ----/+-----------------------------
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
        // https://stackoverflow.com/questions/22668659/calculate-on-which-side-of-a-line-a-point-is
        double  x0 = origin.x, y0 = origin.y,
                x1 = origin.x + displacement.x, y1 = origin.y + displacement.y,
                x2 = p0.x, y2 = p0.y;
        
        double value = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        
        if (value > 0) return Position.LEFT;
        if (value < 0) return Position.RIGHT;
        return Position.HIT;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        //hash = 17 * hash + Objects.hashCode(this.origin);
        // TODO : use normalized origin...
        hash = 17 * hash + Objects.hashCode(this.displacement);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Line2D other = (Line2D) obj;
        if (!Objects.equals(this.displacement, other.displacement)) {
            return false;
        }
        
        // If two different points yield the same value, the lines are the same!
        Point2D p_a1 = this.origin;
        Point2D p_a2 = new Point2D(this.origin.x + this.displacement.x, this.origin.y + this.displacement.y);
        
        Point2D p_b1 = this.getPointForX(this.origin.x);
        Point2D p_b2 = this.getPointForX(this.origin.x + this.displacement.x);
        
        // TODO : edge cases where one or more points are NULL...
        
        return (p_a1.equals(p_b1)) && (p_a2.equals(p_b2));
    }
}
