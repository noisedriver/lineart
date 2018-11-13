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
    
}
