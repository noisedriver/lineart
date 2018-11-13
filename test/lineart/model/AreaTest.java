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
        Coloring coloring = null;
        Area instance = null;
        instance.setColoring(coloring);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColoring method, of class Area.
     */
    @Test
    public void testGetColoring() {
        System.out.println("getColoring");
        Area instance = null;
        Coloring expResult = null;
        Coloring result = instance.getColoring();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Area.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Point2D p = null;
        Area instance = null;
        boolean expResult = false;
        boolean result = instance.contains(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of split method, of class Area.
     */
    @Test
    public void testSplit() {
        System.out.println("split");
        ILine2D line = null;
        Area instance = null;
        Area expResult = null;
        Area result = instance.split(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of relativePosition method, of class Area.
     */
    @Test
    public void testRelativePosition() {
        System.out.println("relativePosition");
        ILine2D line = null;
        Area instance = null;
        Position expResult = null;
        Position result = instance.relativePosition(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
