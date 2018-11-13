package lineart.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schelfaj
 */
public class LineSegment2DTest {

    /**
     * Test of getPoint1 method, of class LineSegment2D.
     */
    @Test
    public void testGetPoint1() {
        System.out.println("getPoint1");
        LineSegment2D instance = null;
        Point2D expResult = null;
        Point2D result = instance.getPoint1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoint2 method, of class LineSegment2D.
     */
    @Test
    public void testGetPoint2() {
        System.out.println("getPoint2");
        LineSegment2D instance = null;
        Point2D expResult = null;
        Point2D result = instance.getPoint2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoundingBox method, of class LineSegment2D.
     */
    @Test
    public void testGetBoundingBox() {
        System.out.println("getBoundingBox");
        LineSegment2D instance = null;
        Rectangle expResult = null;
        Rectangle result = instance.getBoundingBox();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntersection method, of class LineSegment2D.
     */
    @Test
    public void testGetIntersection_LineSegment2D() {
        System.out.println("getIntersection");
        LineSegment2D segment = null;
        LineSegment2D instance = null;
        Point2D expResult = null;
        Point2D result = instance.getIntersection(segment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntersection method, of class LineSegment2D.
     */
    @Test
    public void testGetIntersection_ILine2D() {
        System.out.println("getIntersection");
        ILine2D line = null;
        LineSegment2D instance = null;
        Point2D expResult = null;
        Point2D result = instance.getIntersection(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of asLine method, of class LineSegment2D.
     */
    @Test
    public void testAsLine() {
        System.out.println("asLine");
        LineSegment2D instance = null;
        ILine2D expResult = null;
        ILine2D result = instance.asLine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
