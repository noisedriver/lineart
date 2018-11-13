package lineart.model;

//import java.awt.Polygon;
//import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joris
 */
public class Area {
    
    private final ConvexPolygon convex;
    
    // how correctly transfer/maintain neighbours? this goes on recursively as well...
    //private List<Area> neighbours;
    private Coloring coloring;

    public Area(Coloring coloring, Point2D... points) {
        this.convex = new ConvexPolygon(points);
        this.coloring = coloring;
    }
    
    private static Coloring swapColoring(Coloring coloring) {
        return coloring == Coloring.HORIZONTAL ?
            Coloring.VERTICAL : Coloring.HORIZONTAL;
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
        
        Coloring c = swapColoring(this.coloring);
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean isHit(ILine2D line) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isOnSide1(ILine2D line) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
