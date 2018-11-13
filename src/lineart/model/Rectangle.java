package lineart.model;

import java.util.Objects;

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
        this.width  = Math.abs(width);
        this.height = Math.abs(height);
        this.origin = point;
    }
    
    public Rectangle(LineSegment2D segment) {
        this.width  = Math.abs(segment.getPoint2().x - segment.getPoint1().x);
        this.height = Math.abs(segment.getPoint2().y - segment.getPoint1().y);
        this.origin = new Point2D(
            Math.min(segment.getPoint2().x, segment.getPoint1().x),
            Math.min(segment.getPoint2().y, segment.getPoint1().y)
        );
    }
    
    //@Override
    public boolean contains(Point2D point) {
        double x = point.x, y = point.y,
        x1 = this.origin.x,
        y1 = this.origin.y,
        x2 = this.origin.x + this.width,
        y2 = this.origin.y + this.height; // diagonal
        boolean result = false;
        
        // TODO : make sure bounding box isn't inside-out?
        if (x1 <= x2) {
            if (y1 <= y2)
                return (x >= x1 && x <= x2) && (y >= y1 && y <= y2);
            else
                return (x >= x1 && x <= x2) && (y >= y2 && y <= y1);
        } else {
            if (y1 <= y2)
                return (x >= x2 && x <= x1) && (y >= y1 && y <= y2);
            else
                return (x >= x2 && x <= x1) && (y >= y2 && y <= y1);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.origin);
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
        final Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (!Objects.equals(this.origin, other.origin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + ", origin=" + origin + '}';
    }
}
