package lineart.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joris
 */
public class ConvexPolygon implements Iterable<Point2D> {
    
    protected final List<Point2D> points; // Points making up the boundary

    public ConvexPolygon(Point2D... points) {
        if (points.length < 3)
            throw new IllegalArgumentException("A polygon requires at least 3 non-linear points...");
        //if (points.length == 3) ...
        
        this.points = new LinkedList<>();
        for (int i = 0; i < points.length; ++i) {
            this.points.add(points[i]);
        }
    }
    
    /**
     * Return true if the given point is contained inside the boundary.
     * See: http://www.ecse.rpi.edu/Homepages/wrf/Research/Short_Notes/pnpoly.html
     * @param point The point to check
     * @return true if the point is inside the boundary, false otherwise
     */
    public boolean contains(Point2D point) {
        int i, j;
        boolean result = false;
        
        for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
            
            double val = (points.get(j).x - points.get(i).x) * (point.y - points.get(i).y) / (points.get(j).y - points.get(i).y) + points.get(i).x;
            
            if ((points.get(i).y > point.y) != (points.get(j).y > point.y) && (point.x < val)) {
                result = !result;
            }
        }
      return result;
    }

    @Override
    public Iterator<Point2D> iterator() {
        return this.points.iterator();
    }
    
    /**
     * @param index
     * @return 
     */
    public Point2D getPoint(int index) {
        int i = index % this.points.size(); // circular...
        return this.points.get(i);
    }
    
    public List<LineSegment2D> getEdges() {
        List<LineSegment2D> edges = new LinkedList<>();
        int i = 0, j = 1;
        for (; i < this.points.size() - 1; i++, j++) {
            edges.add(new LineSegment2D(this.points.get(i), this.points.get(j)));
        }
        edges.add(new LineSegment2D(this.points.get(i), this.points.get(0)));
        return edges;
    }
    
    /**
     * Property : areas should always be convex! a line will always create two
     * halve (or 1 if no or 1 intersection is found).
     * 
     * Adding a new point, this point cannot be inside the convex of the previous
     * convex polygon.
     * 
     * A polygon that is "hit" but not "cut" in two halves, returns null.
     * 
     * @param line
     * @return 
     */
    public ConvexPolygon split(ILine2D line) {
        ConvexPolygon c = null;
        for (LineSegment2D edge : getEdges()) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return c;
    }

    public boolean intersects(ILine2D line) {
        return getEdges().stream().anyMatch((edge) -> (edge.getIntersection(line) != null));
    }
}
