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
        System.out.println("getIntersection 1 ");
        
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
     * Test of getIntersection method, of class Line2D.
     */
    @Test
    public void testGetIntersection2() {
        System.out.println("getIntersection 2 ");
        // CASE 5
        ILine2D instance5 = new Line2D(new Point2D(0, 1), new Point2D(1, 0));
        ILine2D other5 = new Line2D(new Point2D(1, 1), new Point2D(0, -0.5));
        Point2D expResult5 = new Point2D(1,0.5);
        Point2D result5 = instance5.getIntersection(other5);
        assertEquals(expResult5, result5);
        //assertEquals(instance5, other5);
    }

    /**
     * Test of isOnLine method, of class Line2D.
     */
    @Test
    public void testIsOnLine() {
        System.out.println("isOnLine");
        
        Line2D instance = new Line2D(new Point2D(5, 1), new Point2D(0, -1));
        
        Point2D p1 = new Point2D(-5,-5);
        boolean expResult1 = false;
        boolean result1 = instance.isOnLine(p1);
        assertEquals(expResult1, result1);
        
        Point2D p2 = new Point2D(10,1);
        boolean expResult2 = true;
        boolean result2 = instance.isOnLine(p2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getOrigin method, of class Line2D.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        
        Line2D instance = new Line2D(new Point2D(1, 1), new Point2D(0, 0));
        Point2D expResult = new Point2D(0, 0);
        Point2D result = instance.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisplacement method, of class Line2D.
     */
    @Test
    public void testGetDisplacement() {
        System.out.println("getDisplacement");
        
        Line2D instance = new Line2D(new Point2D(1, 1), new Point2D(0, 0));
        Point2D expResult = new Point2D(1, 1);
        Point2D result = instance.getDisplacement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPointForX method, of class Line2D.
     */
    @Test
    public void testGetPointForX() {
        System.out.println("getPointForX");
        
        {
            Line2D instance = new Line2D(new Point2D(1, 1), new Point2D(0, 0));

            double x1 = 0.0;
            Point2D expResult1 = new Point2D(0, 0);
            Point2D result1 = instance.getPointForX(x1);
            assertEquals(expResult1, result1);

            double x2 = 5.0;
            Point2D expResult2 = new Point2D(5, 5);
            Point2D result2 = instance.getPointForX(x2);
            assertEquals(expResult2, result2);

            double x3 = 3.5;
            Point2D expResult3 = new Point2D(3.5, 3.5);
            Point2D result3 = instance.getPointForX(x3);
            assertEquals(expResult3, result3);
        }
        
        {
            Line2D instance = new Line2D(new Point2D(1, 2.5), new Point2D(0, 5));

            double x1 = 2.0;
            Point2D expResult1 = new Point2D(2, 5 + 5);
            Point2D result1 = instance.getPointForX(x1);
            assertEquals(expResult1, result1);

            double x2 = 5.0;
            Point2D expResult2 = new Point2D(5, 12.5 + 5);
            Point2D result2 = instance.getPointForX(x2);
            assertEquals(expResult2, result2);

            double x3 = -1;
            Point2D expResult3 = new Point2D(-1, -2.5 + 5);
            Point2D result3 = instance.getPointForX(x3);
            assertEquals(expResult3, result3);
        }
        
        // TODO test edge cases x = d; y = b;
    }

    /**
     * Test of getPointForY method, of class Line2D.
     */
    @Test
    public void testGetPointForY() {
        System.out.println("getPointForY");
        {
            Line2D instance = new Line2D(new Point2D(1, 1), new Point2D(0, 0));

            double y1 = 0.0;
            Point2D expResult1 = new Point2D(0, 0);
            Point2D result1 = instance.getPointForY(y1);
            assertEquals(expResult1, result1);

            double y2 = 5.0;
            Point2D expResult2 = new Point2D(5, 5);
            Point2D result2 = instance.getPointForY(y2);
            assertEquals(expResult2, result2);

            double y3 = 3.5;
            Point2D expResult3 = new Point2D(3.5, 3.5);
            Point2D result3 = instance.getPointForY(y3);
            assertEquals(expResult3, result3);
        }
        
        {
            //       |    /
            //       |   /        
            //       |  / y=ax+b
            //       | /
            //       |/
            //     b-|            
            //  ----/+-----------------------------
            //     / |(0,0)       
            //    /  |            
            
            Line2D instance = new Line2D(new Point2D(5, 1), new Point2D(0, -1));
            
            double y1 = 0.0;
            Point2D result1 = instance.getPointForY(y1);
            Point2D expResult1 = new Point2D(5, 0);
            assertEquals(expResult1, result1);

            double y2 = 5.0; // (5 + 1) * 5 = 30
            Point2D expResult2 = new Point2D(30, 5);
            Point2D result2 = instance.getPointForY(y2);
            assertEquals(expResult2, result2);

            double y3 = 7.5; // (7.5 + 1) * 5 = 42.5
            Point2D expResult3 = new Point2D(42.5, 7.5);
            Point2D result3 = instance.getPointForY(y3);
            assertEquals(expResult3, result3);
        }
    }

    /**
     * Test of relativePosition method, of class Line2D.
     */
    @Test
    public void testRelativePosition() {
        System.out.println("relativePosition");
        
        Line2D instance = new Line2D(new Point2D(5, 1), new Point2D(0, -1));
        
        Point2D p0 = new Point2D();
        Position expResult0 = Position.LEFT;
        Position result0 = instance.relativePosition(p0);
        assertEquals(expResult0, result0);
        
        Point2D p1 = new Point2D(-5,-5);
        Position expResult1 = Position.RIGHT;
        Position result1 = instance.relativePosition(p1);
        assertEquals(expResult1, result1);
        
        Point2D p2 = new Point2D(10,1);
        Position expResult2 = Position.HIT;
        Position result2 = instance.relativePosition(p2);
        assertEquals(expResult2, result2);
    }
}
