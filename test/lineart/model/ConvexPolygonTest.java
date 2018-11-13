/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineart.model;

import java.util.Iterator;
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
        Point2D point = null;
        ConvexPolygon instance = null;
        boolean expResult = false;
        boolean result = instance.contains(point);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class ConvexPolygon.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        ConvexPolygon instance = null;
        Iterator<Point2D> expResult = null;
        Iterator<Point2D> result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoint method, of class ConvexPolygon.
     */
    @Test
    public void testGetPoint() {
        System.out.println("getPoint");
        int index = 0;
        ConvexPolygon instance = null;
        Point2D expResult = null;
        Point2D result = instance.getPoint(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEdges method, of class ConvexPolygon.
     */
    @Test
    public void testGetEdges() {
        System.out.println("getEdges");
        ConvexPolygon instance = null;
        List<LineSegment2D> expResult = null;
        List<LineSegment2D> result = instance.getEdges();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of split method, of class ConvexPolygon.
     */
    @Test
    public void testSplit() {
        System.out.println("split");
        ILine2D line = null;
        ConvexPolygon instance = null;
        ConvexPolygon expResult = null;
        ConvexPolygon result = instance.split(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersects method, of class ConvexPolygon.
     */
    @Test
    public void testIntersects() {
        System.out.println("intersects");
        ILine2D line = null;
        ConvexPolygon instance = null;
        boolean expResult = false;
        boolean result = instance.intersects(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
