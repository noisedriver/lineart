package lineart.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schelfaj
 */
public class AreaTest {
    
    /**
     * Test of setColoring method, of class Area.
     */
    @Test
    public void testSetColoring() {
        System.out.println("setColoring");
        
        Area instance = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(1, 0), new Point2D(0, 1));
        instance.setColoring(Coloring.HORIZONTAL);
        
        Coloring expResult = Coloring.HORIZONTAL;
        Coloring result = instance.getColoring();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColoring method, of class Area.
     */
    @Test
    public void testGetColoring() {
        System.out.println("getColoring");
        Area instance = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(1, 0), new Point2D(0, 1));
        Coloring expResult = Coloring.VERTICAL;
        Coloring result = instance.getColoring();
        assertEquals(expResult, result);
    }

    /**
     * Test of split method, of class Area.
     */
    @Test
    public void testSplit1() {
        System.out.println("split1");
        
        Area instance = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(1, 0), new Point2D(1, 1));
        
        ILine2D line = new Line2D(new Point2D(1, 1), new Point2D(0, -0.5));
        
        Area expResult = new Area(Coloring.VERTICAL,
                new Point2D(0.5, 0), new Point2D(1, 0), new Point2D(1, 0.5));
        
        Area result = instance.split(line);
        assertEquals(expResult, result);
        
        Area expResult2 = new Area(Coloring.VERTICAL,
                new Point2D(), new Point2D(0.5, 0), new Point2D(1, 0.5), new Point2D(1, 1));
        assertEquals(expResult2, instance);
    }
    
    @Test
    public void testSplit2() {
        //if (true) return;
        System.out.println("split2");
        
        // INPUT :
        Area instance = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(1, -1), new Point2D(2, 0),
                new Point2D(1, 1), new Point2D(0, 1));
        ILine2D line = new Line2D(new Point2D(1, 1), new Point2D(0, -0.5));
        
        // EXECUTE :
        Area result = instance.split(line);
        
        // RESULTS :
        Area expResult = new Area(Coloring.VERTICAL,
                new Point2D(0.25, -0.25), new Point2D(-1, -1),
                new Point2D(2, 0), new Point2D(1.25, 0.75));
        assertEquals(expResult, result);
        
        Area expResult2 = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(0.25, -0.25),
                new Point2D(1.25, 0.75), new Point2D(1, 1), new Point2D(0, 1));
        assertEquals(expResult2, instance);
    }
    
    
    @Test
    public void testSplit3() {
        //if (true) return;
        System.out.println("split3");
        
        // INPUT :
        Area instance = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(1024, 0),
                new Point2D(1024, 1024), new Point2D(0, 1024));
        // y = ax+b ~ 1024 = 2x - 50 <-> 1074/2 = 537 = x
        ILine2D line = new Line2D(new Point2D(50, 100), new Point2D(0, -50));
        
        // EXECUTE :
        Area result = instance.split(line);
        
        // RESULTS :
        Area expResult = new Area(Coloring.VERTICAL,
                new Point2D(25, 0), new Point2D(1024, 0),
                new Point2D(1024, 1024), new Point2D(537, 1024));
        assertEquals(expResult, result);
        
        Area expResult2 = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(25, 0),
                new Point2D(537, 1024), new Point2D(0, 1024));
        assertEquals(expResult2, instance);
    }


    /**
     * Test of relativePosition method, of class Area.
     */
    @Test
    public void testRelativePosition() {
        System.out.println("relativePosition");
        
        
        Area instance = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(1, 0), new Point2D(1, 1));
        
        ILine2D line = new Line2D(new Point2D(1, 1), new Point2D(0, -0.5));
        Position expResult = Position.HIT;
        Position result = instance.relativePosition(line);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of relativePosition method, of class Area.
     */
    @Test
    public void testFlipColoring() {
        System.out.println("flipColoring");
        
        
        Area instance = new Area(Coloring.VERTICAL,
                new Point2D(0, 0), new Point2D(1, 0), new Point2D(1, 1));
        
        Coloring expResult = Coloring.HORIZONTAL;
        
        instance.flipColoring();
        Coloring result = instance.getColoring();
        
        assertEquals(expResult, result);
    }
}
