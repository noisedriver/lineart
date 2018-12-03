package lineart.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schelfaj
 */
public class ConvexPolygonTest {
    
    /**
     * Test of contains method, of class ConvexPolygon.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        
        {
            Point2D point = new Point2D();
            ConvexPolygon instance = new ConvexPolygon(
                new Point2D(-1, -1),
                new Point2D( 1, -1),
                new Point2D( 1,  1),
                new Point2D(-1,  1)
            );
            boolean expResult = true;
            boolean result = instance.contains(point);
            assertEquals(expResult, result);
        }
        
        {
            Point2D point = new Point2D(10,7);
            ConvexPolygon instance = new ConvexPolygon(
                new Point2D(-1, -1),
                new Point2D( 1, -1),
                new Point2D( 1,  2),
                new Point2D(-1,  2),
                new Point2D(-2,  1)
            );
            boolean expResult = false;
            boolean result = instance.contains(point);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getPoint method, of class ConvexPolygon.
     */
    @Test
    public void testGetPoint() {
        System.out.println("getPoint");
        
        ConvexPolygon instance = new ConvexPolygon(
                new Point2D(-1, -1),
                new Point2D( 1, -1),
                new Point2D( 1,  2),
                new Point2D(-1,  2),
                new Point2D(-2,  1)
            );
        Point2D expResult = new Point2D(1,2);
        int index = 2;
        Point2D result = instance.getPoint(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEdges method, of class ConvexPolygon.
     */
    @Test
    public void testGetEdges() {
        System.out.println("getEdges");
        
        ConvexPolygon instance = new ConvexPolygon(
            new Point2D(-1, -1),
            new Point2D( 1, -1),
            new Point2D( 1,  2),
            new Point2D(-1,  2),
            new Point2D(-2,  1)
        );
        List<LineSegment2D> result = instance.getEdges();
        assertEquals(new LineSegment2D(new Point2D(-1, -1), new Point2D( 1, -1)), result.get(0));
        assertEquals(new LineSegment2D(new Point2D( 1, -1), new Point2D( 1,  2)), result.get(1));
        assertEquals(new LineSegment2D(new Point2D( 1,  2), new Point2D(-1,  2)), result.get(2));
        assertEquals(new LineSegment2D(new Point2D(-1,  2), new Point2D(-2,  1)), result.get(3));
        assertEquals(new LineSegment2D(new Point2D(-2,  1), new Point2D(-1, -1)), result.get(4));
    }

    /**
     * Test of split method, of class ConvexPolygon.
     */
    @Test
    public void testSplit() {
        System.out.println("split");
        
        ConvexPolygon instance = new ConvexPolygon(
            new Point2D(-2, -2),
            new Point2D( 2, -2),
            new Point2D( 2,  2),
            new Point2D(-2,  2)
        );
        
        //              ^ y  /
        //              |   /   (2,2)
        //      +-------|--/----+
        //      |       | /     |
        //      |       |/      |        x
        //   -----------+--------------->
        //      |      /|       |
        //      |     / |       |
        //      +----/--|-------+
        //          /   |
        
        ILine2D line = new Line2D(new Point2D(1, 2), new Point2D(0, 0));
        
        ConvexPolygon expResultA = new ConvexPolygon(
            new Point2D(-2, -2),
            new Point2D(-1, -2),
            new Point2D( 1,  2),
            new Point2D(-2,  2)
        );
        
        ConvexPolygon expResultB = new ConvexPolygon(
            new Point2D(-1, -2),
            new Point2D( 2, -2),
            new Point2D( 2,  2),
            new Point2D( 1,  2)
        );
        
        ConvexPolygon result = instance.split(line);
        assertEquals(expResultA, instance);
        assertEquals(expResultB, result);
    }

    /**
     * Test of intersects method, of class ConvexPolygon.
     */
    @Test
    public void testIntersects() {
        System.out.println("intersects");
        
        ConvexPolygon instance = new ConvexPolygon(
            new Point2D(-1, -1),
            new Point2D( 1, -1),
            new Point2D( 1,  2),
            new Point2D(-1,  2),
            new Point2D(-2,  1)
        );
        
        Line2D line = new Line2D(new Point2D(1,1), new Point2D(0,0));
        boolean expResult = true;
        boolean result = instance.intersects(line);
        assertEquals(expResult, result);
    }
}
