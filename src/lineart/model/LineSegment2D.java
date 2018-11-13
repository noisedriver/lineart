package lineart.model;

import java.util.Objects;

/**
 *
 * @author noisedriver
 */
public class LineSegment2D {
    
    private final Point2D point1;
    private final Point2D point2;
    
    public LineSegment2D(Point2D point1, Point2D point2) {
        // TODO : assert ordering point1 < point2 ?
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
        // note : no area if colinear...
        return new Rectangle(this);
    }
    
    // https://stackoverflow.com/questions/16314069/calculation-of-intersections-between-line-segments
    public Point2D getIntersection(LineSegment2D segment) {
        Point2D p1  = segment.point1, p2  = segment.point2, _p1 = this.point1, _p2 = this.point2;
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

    public Point2D getIntersection(ILine2D line) {
        // recreate the sgement as a line, solve the equation and check if the
        // solution is inside the bounding box of the segment.
        ILine2D temp = this.asLine();
        Point2D p = line.getIntersection(temp);
        return this.getBoundingBox().contains(p) ? p : null;
    }
    
    public ILine2D asLine() {
        return new Line2D(new Point2D(this.point2.x - this.point1.x, this.point2.y - this.point1.y), this.point1);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.point1);
        hash = 89 * hash + Objects.hashCode(this.point2);
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
        final LineSegment2D other = (LineSegment2D) obj;
        if (!Objects.equals(this.point1, other.point1)) {
            return false;
        }
        if (!Objects.equals(this.point2, other.point2)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "LineSegment2D{" + "point1=" + point1 + ", point2=" + point2 + '}';
    }
}
