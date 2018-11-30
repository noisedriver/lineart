package lineart.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A convex hull N-polygon with N > 2.
 * 
 * @see https://algs4.cs.princeton.edu/91primitives/
 * @author noisedriver
 */
public class ConvexPolygon implements Iterable<Point2D> {
    
    protected final List<Point2D> points; // Points making up the boundary

    public ConvexPolygon(Point2D... points) {
        if (points.length < 3)
            throw new IllegalArgumentException("A polygon requires at least 3 non-linear points...");
        //if (points.length == 3) ...
        
        this.points = new LinkedList<>();
        for (int i = 0; i < points.length; ++i) {
            // TODO : add check for each point if the new figure is convex !!!!!
            this.points.add(points[i]);
        }
    }
    
    public ConvexPolygon(Collection<Point2D> points) {
        if (points.size() < 3)
            throw new IllegalArgumentException("A polygon requires at least 3 non-linear points...");
        //if (points.length == 3) ...
        
        this.points = new LinkedList<>(points);
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
    
    /**
     * @param index
     * @return 
     */
    public LineSegment2D getEdge(int index) {
        return new LineSegment2D(this.getPoint(index), this.getPoint(index + 1));
    }
    
    public List<LineSegment2D> getEdges() {
        List<LineSegment2D> edges = new LinkedList<>();
        int N = this.points.size();
        for (int i = 0; i < N - 1; i++) {
            edges.add(new LineSegment2D(this.points.get(i), this.points.get(i + 1)));
        }
        edges.add(new LineSegment2D(this.points.get(N - 1), this.points.get(0)));
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
        
        LinkedList<Point2D> polygon1 = new LinkedList<>();
        LinkedList<Point2D> polygon2 = new LinkedList<>();
        boolean polygon1_active = true;
        int splits = 0;
        // Polygon to ordered sequence of edges...
        Collection<LineSegment2D> edges = getEdges();
        
        // Walk through the edges;
        // For each edge, test if there is an intersection
        // IF there is an intersection:
        //      split the edge into two parts;
        //      add the first part to the current stack
        //      add the second part to the other stack
        //      the other stack now becomes the "current" stack and continue...
        // ELSE
        //      keep adding to the current stack and test the next edge for an
        //      intersection...
        for (LineSegment2D edge : edges) {
            
            if (polygon1_active)
                polygon1.add(edge.getPoint1());
            else
                polygon2.add(edge.getPoint1());
            
            Point2D p = edge.getIntersection(line);
            if (p != null) {
                polygon1_active = !polygon1_active;
                splits++;
                polygon1.add(p); // add case for when p == point1 or point2?
                polygon2.add(p);
                /*if (polygon1_active) {
                    polygon1.add(edge.getPoint2());
                } else {
                    polygon2.add(edge.getPoint2());
                }*/
            }
        }
        
        // Only split the convex polygon 
        if (splits != 2) // for non-convex, mod 2 can be used?
            return null;
        
        this.points.clear();
        this.points.addAll(polygon1);
        
        if (! polygon2.isEmpty() && polygon2.size() > 2)
            c = new ConvexPolygon(polygon2);
        
        return c;
    }

    public boolean intersects(ILine2D line) {
        return getEdges().stream().anyMatch((edge) -> (edge.getIntersection(line) != null));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (Point2D p : this)
            hash = 83 * hash + Objects.hashCode(p);
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
        final ConvexPolygon other = (ConvexPolygon) obj;
        for (Point2D p : this)
            if (! other.hasPoint(p)) return false;
        return true;
    }

    public boolean hasPoint(Point2D point) {
        for (Point2D p : this)
            if (p.equals(point)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "ConvexPolygon{" + "points=" + points + '}';
    }
    
}
