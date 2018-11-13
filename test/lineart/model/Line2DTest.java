package lineart.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schelfaj
 */
public class Line2DTest {

    /**
     * Test of getIntersection method, of class Line2D.
     */
    @Test
    public void testGetIntersection() {
        System.out.println("getIntersection");
        
        Line2D instance = new Line2D(new Point2D(1, 1), new Point2D(0, 0));
        
        // CASE 1
        ILine2D other = new Line2D(new Point2D(1, 0.5), new Point2D(0, 4));
        Point2D expResult = new Point2D(8,8);
        Point2D result = instance.getIntersection(other); //System.out.println(result.toString());
        assertEquals(expResult, result);
        
        // CASE 2
        ILine2D other2 = new Line2D(new Point2D(1, -2), new Point2D(0, 6));
        Point2D expResult2 = new Point2D(2,2);
        Point2D result2 = instance.getIntersection(other2); //System.out.println(result.toString());
        assertEquals(expResult2, result2);
        
        // CASE 3
        ILine2D other3 = new Line2D(new Point2D(1, 1), new Point2D(0, 6));
        Point2D expResult3 = null;
        Point2D result3 = instance.getIntersection(other3);
        assertEquals(expResult3, result3);
        
        // CASE 3
        //ILine2D other4 = new Line2D(new Point2D(1, 1), new Point2D(100, 100));
        //Point2D expResult4 = new Point2D(0,0);
        //Point2D result4 = instance.getIntersection(other4);
        //assertEquals(expResult4, result4);
        //assertEquals(instance, other4);
    }

    /**
     * Test of isOnLine method, of class Line2D.
     */
    @Test
    public void testIsOnLine() {
        System.out.println("isOnLine");
        /*
        Point2D point = null;
        Line2D instance = null;
        boolean expResult = false;
        boolean result = instance.isOnLine(point);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of getOrigin method, of class Line2D.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        /*
        Line2D instance = null;
        Point2D expResult = null;
        Point2D result = instance.getOrigin();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of getDisplacement method, of class Line2D.
     */
    @Test
    public void testGetDisplacement() {
        System.out.println("getDisplacement");
        /*
        Line2D instance = null;
        Point2D expResult = null;
        Point2D result = instance.getDisplacement();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of getPointForX method, of class Line2D.
     */
    @Test
    public void testGetPointForX() {
        System.out.println("getPointForX");
        /*
        double x = 0.0;
        Line2D instance = null;
        Point2D expResult = null;
        Point2D result = instance.getPointForX(x);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of getPointForY method, of class Line2D.
     */
    @Test
    public void testGetPointForY() {
        System.out.println("getPointForY");
        /*
        double y = 0.0;
        Line2D instance = null;
        Point2D expResult = null;
        Point2D result = instance.getPointForY(y);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of relativePosition method, of class Line2D.
     */
    @Test
    public void testRelativePosition() {
        System.out.println("relativePosition");
        /*
        Point2D p0 = null;
        Line2D instance = null;
        Position expResult = null;
        Position result = instance.relativePosition(p0);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        */
    }
    
}
