package lineart.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author noisedriver
 */
public class RectangleTest {

    /**
     * Test of contains method, of class Rectangle.
     */
    @Test
    public void testRectangle() {
        System.out.println("Rectangle");
        // TODO : test constructor...
        Rectangle instance = new Rectangle(300, 100, new Point2D());
        assertEquals(100, instance.height, 0.0);
        assertEquals(300, instance.width, 0.0);
    }
    
    /**
     * Test of contains method, of class Rectangle.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Rectangle instance = new Rectangle(300, 200, new Point2D(0, 0));
        
        Point2D point1 = new Point2D(50, 40);
        boolean expResult1 = true;
        boolean result1 = instance.contains(point1);
        assertEquals(expResult1, result1);
        
        Point2D point2 = new Point2D(500, 400);
        boolean expResult2 = false;
        boolean result2 = instance.contains(point2);
        assertEquals(expResult2, result2);
        
        Point2D point3 = new Point2D(100, 200);
        boolean expResult3 = true;
        boolean result3 = instance.contains(point3);
        assertEquals(expResult3, result3);
    }
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        Rectangle r1 = new Rectangle(300, 200, new Point2D(0, 0));
        // CASES
        Rectangle r2 = new Rectangle(300, 200, new Point2D(0, 0));
        Rectangle r3 = new Rectangle(300, 200, new Point2D(1, 1));
        Rectangle r4 = new Rectangle(200, 200, new Point2D(0, 0));
        Rectangle r5 = new Rectangle(300, 300, new Point2D(0, 0));
        Rectangle r6 = new Rectangle(300, 300, new Point2D(1, 1));
        Rectangle r9 = new Rectangle(-300, -200, new Point2D(0, 0)); // w/h abs
        
        assertTrue(r1.equals(r2));
        assertTrue(r1.equals(r9));
        assertFalse(r1.equals(r3));
        assertFalse(r1.equals(r4));
        assertFalse(r1.equals(r5));
        assertFalse(r1.equals(r6));
        
        // Different constructor
        Rectangle r7 = new Rectangle(new LineSegment2D(new Point2D(0, 0), new Point2D(300,200)));
        Rectangle r8 = new Rectangle(300,200);
        assertTrue(r7.equals(r8));
    }
    
    @Test
    public void testBottomLeft() {
        System.out.println("getBottomLeft");
        Rectangle r1 = new Rectangle(300, 200, new Point2D(0, 0));
        Rectangle r2 = new Rectangle(300, 200, new Point2D(900, 100));
        
        Point2D e1 = new Point2D();
        Point2D e2 = new Point2D(900,100);
        
        assertEquals(e1, r1.getBottomLeft());
        assertEquals(e2, r2.getBottomLeft());
    }
    
    @Test
    public void testTopRight() {
        System.out.println("getTopRight");
        Rectangle r1 = new Rectangle(300, 200, new Point2D(0, 0));
        Rectangle r2 = new Rectangle(300, 200, new Point2D(900, 100));
        
        Point2D e1 = new Point2D(300,200);
        Point2D e2 = new Point2D(1200,300);
        
        assertEquals(e1, r1.getTopRight());
        assertEquals(e2, r2.getTopRight());
    }
}
