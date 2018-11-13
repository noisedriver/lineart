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
        Canvas instance = null;
        Rectangle expResult = null;
        Rectangle result = instance.getBounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLine method, of class Canvas.
     */
    @Test
    public void testAddLine() {
        System.out.println("addLine");
        ILine2D line = null;
        Canvas instance = null;
        instance.addLine(line);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Canvas.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        int i = 0;
        int j = 0;
        Canvas instance = null;
        int expResult = 0;
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
        Canvas instance = null;
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Canvas.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Canvas instance = null;
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLineWidth method, of class Canvas.
     */
    @Test
    public void testGetLineWidth() {
        System.out.println("getLineWidth");
        Canvas instance = null;
        int expResult = 0;
        int result = instance.getLineWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
