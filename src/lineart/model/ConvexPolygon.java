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
    
    public List<LineSegment2D> getEdges() {
        List<LineSegment2D> edges = new LinkedList<>();
        int i = 0, j = 1;
        for (; i < this.points.size() - 1; i++, j++) {
            edges.add(new LineSegment2D(this.points.get(i), this.points.get(j)));
        }
        edges.add(new LineSegment2D(this.points.get(0), this.points.get(j)));
        return edges;
    }
    
    /**
     * Property : areas should always be convex! a line will always create two
     * halve (or 1 if no or 1 intersection is found).
     * 
     * Adding a new point, this point cannot be inside the convex of the previous
     * convex polygon.
     * 
     * @param line
     * @return 
     */
    public Area split(ILine2D line) {
        Area a = null;
        for (LineSegment2D edge : getEdges()) {
            
        }
        return a;
    }
}
