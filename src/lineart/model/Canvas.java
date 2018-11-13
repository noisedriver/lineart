package lineart.model;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Joris
 */
public class Canvas {
    
    private final int width;
    private final int height;
    private final int lineWidth;
    private final List<Area> areas;

    public Canvas(int width, int height, int lineWidth) {
        assert(width > 0 && height > 0);
        this.width = width;
        this.height = height;
        this.lineWidth = lineWidth;
        this.areas = new LinkedList<>();
        
        // Adding initial area...
        this.areas.add(new Area(Coloring.VERTICAL,
                                new Point2D(0,0),
                                new Point2D(0,height),
                                new Point2D(width,height),
                                new Point2D(width,0)));
    }
    
    public Rectangle getBounds() {
        return new Rectangle(this.width, this.height, new Point2D());
    }
    
    public void addLine(ILine2D line) {
        if (! lineWithinBounds(line)) return;
        
        List<Area> hits  = new LinkedList<>();
        List<Area> side1 = new LinkedList<>();
        List<Area> side2 = new LinkedList<>();
        
        // determine all the areas on one side of the boundary, and all areas on
        // the other side. Then determine all the areas that are hit by the line
        // and divide the areas accordingly, adding each side of a split to the
        // appropriate list of areas.
        // Finally swap the coloring type of each area in one one of the two
        // lists...
        
        
        
        this.areas.stream().forEach((a) -> {
            
            // 1. left of, right of, or on the boundary?
            if (a.isHit(line))
                hits.add(a);
            else if (a.isOnSide1(line))
                side1.add(a);
            else
                side2.add(a);
            
            // do same for split areas...
            //Area b = a.split(line);
            //areas.add(a);
            //if (b != null) areas.add(b);
        });
        
        assert(hits.isEmpty());
        // swap all colours for bucket 2...
        side2.stream().forEach((a) -> {
            a.setColoring(a.getColoring() == Coloring.VERTICAL ? Coloring.HORIZONTAL : Coloring.VERTICAL);
        });
        
        // Update areas...
        this.areas.clear();
        this.areas.addAll(side1);
        this.areas.addAll(side2);
    }
    
    /**
     * @param line
     * @return 
     */
    private boolean lineWithinBounds(ILine2D line) {
        
        /*Rectangle bounds = getBounds();
        
        Point2D p1 = this.lines.get(1).getIntersection(line);
        if (this.getBounds().contains(p0)) return true;
        
        Point2D p1 = this.lines.get(1).getIntersection(line);
        if (this.getBounds().contains(p1)) return true;
        
        Point2D p2 = this.lines.get(2).getIntersection(line);
        if (this.getBounds().contains(p2)) return true;
        
        Point2D p3 = this.lines.get(3).getIntersection(line);
        return this.getBounds().contains(p3);*/
        return true;
    }
    
    // resolution i,j grid ~ WIDTH x HEIGHT plane
    private Coloring getColoring(int i, int j) {
        Point2D p = new Point2D(i, j);
        for (Area a : this.areas)
            if (a.contains(p)) return a.getColoring();
        // Default :
        return Coloring.VERTICAL;
    }
    
    public int getColor(int i, int j) {
        if (this.getColoring(i,j) == Coloring.VERTICAL) {
            // Set grid values...
            if (j / this.lineWidth % 2 == 0) return 255;
        } else {
            if (i / this.lineWidth % 2 == 0) return 255;
        }
        return 0;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getLineWidth() {
        return this.lineWidth;
    }
}
