package lineart.model;

import lineart.model.exception.EquivalentLineException;
import lineart.model.exception.NoIntersectionException;
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
        LineSegment2D instance = new LineSegment2D(new Point2D(), new Point2D(1,1));
        Point2D expResult = new Point2D(0,0);
        Point2D result = instance.getPoint1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoint2 method, of class LineSegment2D.
     */
    @Test
    public void testGetPoint2() {
        System.out.println("getPoint2");
        LineSegment2D instance = new LineSegment2D(new Point2D(), new Point2D(1,1));
        Point2D expResult = new Point2D(1, 1);
        Point2D result = instance.getPoint2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBoundingBox method, of class LineSegment2D.
     */
    @Test
    public void testGetBoundingBox() {
        System.out.println("getBoundingBox");
        LineSegment2D instance = new LineSegment2D(new Point2D(), new Point2D(1,1));
        Rectangle expResult = new Rectangle(1, 1, new Point2D(0,0));
        Rectangle result = instance.getBoundingBox();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIntersection method, of class LineSegment2D.
     */
    @Test
    public void testGetIntersection_LineSegment2D() {
        System.out.println("getIntersection");
        
        LineSegment2D segment = new LineSegment2D(new Point2D(), new Point2D(1,1));
        
        {
            LineSegment2D instance = new LineSegment2D(new Point2D(0,0.5), new Point2D(1,0.5));
            Point2D expResult = new Point2D(0.5, 0.5);
            Point2D result = instance.getIntersection(segment);
            assertEquals(expResult, result);
        }
        
        
        {
            LineSegment2D instance = new LineSegment2D(new Point2D(0,1.5), new Point2D(1,1.5));
            Point2D expResult = null;
            Point2D result = instance.getIntersection(segment);
            assertEquals(expResult, result);
        }
    }
    
    /**
     * Test of getIntersection method, of class LineSegment2D.
     */
    @Test
    public void testGetIntersection_ILine2D() {
        System.out.println("getIntersection(ILine2D)");
        
        
        try {
            LineSegment2D instance = new LineSegment2D(new Point2D(0,0), new Point2D(1,1));
            ILine2D line = new Line2D(new Point2D(1,0), new Point2D(0,0.5));
            Point2D expResult = new Point2D(0.5, 0.5);
            Point2D result = instance.getIntersection(line);
            assertEquals(expResult, result);
        } catch(NoIntersectionException | EquivalentLineException e) {
            fail();
        }
        
        try {
            LineSegment2D instance = new LineSegment2D(new Point2D(2,2), new Point2D(-2,2));
            ILine2D line = new Line2D(new Point2D(1, 2), new Point2D(0, 0));
            Point2D expResult = new Point2D(1, 2);
            Point2D result = instance.getIntersection(line);
            assertEquals(expResult, result);
        } catch(NoIntersectionException | EquivalentLineException e) {
            fail();
        }
    }

    /**
     * Test of asLine method, of class LineSegment2D.
     */
    @Test
    public void testAsLine() {
        System.out.println("asLine");
        
        // CASE 1
        LineSegment2D instance1 = new LineSegment2D(new Point2D(0,0), new Point2D(1,1));
        ILine2D result1 = instance1.asLine();
        
        assertEquals(new Point2D(1,1), result1.getDisplacement());
        assertEquals(new Point2D(0,0), result1.getPointForX(0));
        
        
        // CASE 2
        LineSegment2D instance2 = new LineSegment2D(new Point2D(2, 0), new Point2D(1,1));
        ILine2D result2 = instance2.asLine();
        
        assertEquals(new Point2D(1,-1), result2.getDisplacement());
        assertEquals(new Point2D(0,2), result2.getPointForX(0));
    }
    
}
