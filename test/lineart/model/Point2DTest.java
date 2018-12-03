package lineart.model;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author schelfaj
 */
public class Point2DTest {

    @Test
    public void testPoint2D() {
        
        // Testing constructor :
        
        Point2D p1 = new Point2D();
        assertEquals(0.0, p1.x, 0.0);
        assertEquals(0.0, p1.y, 0.0);
        
        Point2D p2 = new Point2D(0, 0);
        assertEquals(0.0, p2.x, 0.0);
        assertEquals(0.0, p2.y, 0.0);
        
        Point2D p3 = new Point2D(15, -9);
        assertEquals(15.0, p3.x, 0.0);
        assertEquals(-9.0, p3.y, 0.0);
    }
    
    @Test
    public void testEquals() {
        
        Point2D p1 = new Point2D(25, -8);
        Point2D p2 = new Point2D(25, -8);
        Point2D p3 = new Point2D(25, -7);
        Point2D p4 = new Point2D(15, -8);
        Point2D p5 = new Point2D(15, -7);
        
        assertTrue (p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p4));
        assertFalse(p1.equals(p5));
    }
    
    @Test
    public void testToString() {
        
        Point2D p1 = new Point2D(25, -8);
        Point2D p2 = new Point2D(.2, 10);
        
        String s1 = "Point2D{x=25.0, y=-8.0}";
        String s2 = "Point2D{x=0.2, y=10.0}";
        String r1 = p1.toString();
        String r2 = p2.toString();
        //System.out.println(s1 + " ~ " + r1);
        //System.out.println(s2 + " ~ " + r2);
        
        assertEquals(s1, r1);
        assertEquals(s2, r2);
    }
}
