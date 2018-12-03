package lineart.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schelfaj
 */
public class CanvasTest {

    /**
     * Test of getBounds method, of class Canvas.
     */
    @Test
    public void testGetBounds() {
        System.out.println("getBounds");
        Canvas instance = new Canvas(100, 100, 2);
        Rectangle expResult = new Rectangle(100,100);
        Rectangle result = instance.getBounds();
        assertEquals(expResult, result);
    }

    /**
     * Test of addLine method, of class Canvas.
     */
    @Test
    public void testAddLine() {
        System.out.println("addLine");
        
        fail("The test case is a prototype.");
        if (true) return;
        
        final int WIDTH = 1024, HEIGHT = 1024, LINE_WIDTH = 5;
        Canvas canvas = new Canvas(WIDTH, HEIGHT, LINE_WIDTH);
        Line2D line = new Line2D(new Point2D(50, 100), new Point2D(0, 50));
        canvas.addLine(line);
        
        assertTrue (canvas.getAreas().size() == 2);
    }

    /**
     * Test of getColor method, of class Canvas.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        int i = 0;
        int j = 0;
        
        final int WIDTH = 1024, HEIGHT = 1024, LINE_WIDTH = 5;
        Canvas instance = new Canvas(WIDTH, HEIGHT, LINE_WIDTH);
        
        int expResult = 255;
        int result = instance.getColor(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Canvas.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Canvas instance = new Canvas(400, 100, 2);
        int expResult = 400;
        int result = instance.getWidth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method, of class Canvas.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Canvas instance = new Canvas(200, 100, 2);
        int expResult = 100;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLineWidth method, of class Canvas.
     */
    @Test
    public void testGetLineWidth() {
        System.out.println("getLineWidth");
        Canvas instance = new Canvas(100, 100, 2);
        int expResult = 2;
        int result = instance.getLineWidth();
        assertEquals(expResult, result);
    }
    
}
