package lineart.model;

import java.util.Objects;

/**
 * An a area is a convex polygon with a specific coloring style.
 * @author noisedriver
 */
public class Area {
    
    private final ConvexPolygon convex;
    private Coloring coloring; // colouring can change

    public Area(Coloring coloring, ConvexPolygon polygon) {
        this.convex = polygon;
        this.coloring = coloring;
    }
    
    public Area(Coloring coloring, Point2D... points) {
        this(coloring, new ConvexPolygon(points));
    }
    
    public void setColoring(Coloring coloring) {
        this.coloring = coloring;
    }
    
    public Coloring getColoring() {
        return this.coloring;
    }
    
    public boolean contains(Point2D p) {
        return this.convex.contains(p);
    }
    
    /**
     * Property : areas should always be convex! a line will always create two
     * halve (or 1 if no or 1 intersection is found)
     * @param line
     * @return 
     */
    public Area split(ILine2D line) {
        ConvexPolygon polygon = this.convex.split(line);
        return (polygon != null) ? new Area(this.coloring, polygon) : null;
    }

    /**
     * Verify if the area is left of clockwise
     * @see 
     * @param line
     * @return 
     */
    public Position relativePosition(ILine2D line) {
        if (this.convex.intersects(line))
            return Position.HIT;
        // We only need to check for 1 point, as we have already ruled out that
        // the line intersects with the area...
        Point2D p0 = this.convex.getPoint(0);
        return line.relativePosition(p0);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.convex);
        hash = 37 * hash + Objects.hashCode(this.coloring);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Area other = (Area) obj;
        if (!Objects.equals(this.convex, other.convex)) {
            return false;
        }
        return this.coloring == other.coloring;
    }

    @Override
    public String toString() {
        return "Area{" + "convex=" + convex + ", coloring=" + coloring + '}';
    }
    
    public void flipColoring() {
        this.setColoring(this.getColoring() == Coloring.VERTICAL ? Coloring.HORIZONTAL : Coloring.VERTICAL);
    }
}
