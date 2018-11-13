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
}
