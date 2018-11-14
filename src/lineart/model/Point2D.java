package lineart.model;

/**
 * 2D Point class. To be considered as value container for x and y coordinates.
 * @author noisedriver
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
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
        final Point2D other = (Point2D) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Point2D{" + "x=" + x + ", y=" + y + '}';
    }
}
