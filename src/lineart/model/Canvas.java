package lineart.model;

import java.util.List;
import java.util.LinkedList;

/**
 * A class that maintains the areas created by splitting the initial area by
 * a number of lines.
 * @author noisedriver
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
    
    // determine all the areas on one side of the boundary, and all areas on
    // the other side. Then determine all the areas that are hit by the line
    // and divide the areas accordingly, adding each side of a split to the
    // appropriate list of areas.
    // Finally swap the coloring type of each area in one one of the two
    // lists...
    public void addLine(ILine2D line) {
        if (! lineWithinBounds(line)) return;
        
        List<Area> left  = new LinkedList<>();
        List<Area> right = new LinkedList<>();
        
        this.areas.stream().forEach((a) -> {
            splitAreas(a, line, left, right);
        });
        
        // swap all colours for the areas in the right bucket...
        right.stream().forEach((a) -> {
            a.flipColoring();
        });
        
        // Update areas...
        this.areas.clear();
        this.areas.addAll(left);
        this.areas.addAll(right);
    }
    
    /**
     * 
     * @param area
     * @param line
     * @param left
     * @param right 
     */
    private static void splitAreas(Area area, ILine2D line, List<Area> left, List<Area> right) {
        // 1. left of, right of, or on the boundary?
        Position p = area.relativePosition(line);
        switch (p) {
            case HIT:
                // Recursively split areas...
                Area b = area.split(line);
                if (b != null) {
                    Canvas.splitAreas(area, line, left, right);
                    Canvas.splitAreas(b, line, left, right);
                } else {
                    // Add by default to left if the area is "hit" but not "split"
                    left.add(area);
                }
                break;
            case LEFT:
                left.add(area);
                break;
            case RIGHT:
                right.add(area);
                break;
            default:
                break;
        }
    }
    
    /**
     * @param line
     * @return 
     */
    private boolean lineWithinBounds(ILine2D line) { // TODO...
        
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
