package lineart.model;


/**
 * <p>
 *  In mathematics, a linear equation is an equation that may be put in the form
 *  <br />
 *      ax + b = 0
 *  <br />
 *  where x is the variable (or unknown or indeterminate), and a and b are the
 *  coefficients, which are often real numbers. The coefficients may be
 *  considered as parameters of the equation, and may be stated as arbitrary
 *  expressions, restricted to not contain any of the variables.
 * </p>
 * <p>
 *  To yield a meaningful equation for non-zero values of b, the coefficients
 *  are required not to be all zeros.
 * </p>
 * @see https://en.wikipedia.org/wiki/Linear_equation
 * 
 * @author Joris
 */
public interface ILine2D {
    
    public Point2D getOrigin();
    
    public Point2D getDisplacement();
    
    /**
     * 
     * @param x
     * @return the point at (x,y) with ax+b=y
     *         null if of the form x = c and x' != c
     */
    public Point2D getPointForX(double x);
    
    /**
     * 
     * @param y
     * @return the point at ((x-b)/a,y) for ax+b=y
     *         null if y = b and y' != b
     */
    public Point2D getPointForY(double y);
    
    /**
     * <p>
     *  Lines that are parallel (equal slope) will not have an intersection. For
     *  a line L1 <-> ax+b = y and L2 <-> cx + d = y, they will have an
     *  intersection at Point (x',y') with:
     *  <br />  x' = (d-b)/(a-c); y' = c(x') + d
     * </p>
     * 
     * if (this.getSlope() == line.getSlope()) result == null
     * 
     * @param line
     * @return 
     */
    public Point2D getIntersection(ILine2D line);
    
    /**
     * 
     * @param point
     * @return 
     */
    public boolean isOnLine(Point2D point);

    /**
     * <p>
     * Given a directed line from point p0(x0, y0) to p1(x1, y1), you can use
     * the following condition to decide whether a point p2(x2, y2) is on the
     * left of the line, on the right, or on the same line:
     * 
     *      value = (x1 - x0)(y2 - y0) - (x2 - x0)(y1 - y0)
     *      
     *      if value > 0, p2 is on the left side of the line.
     *      if value = 0, p2 is on the same line.
     *      if value < 0, p2 is on the right side of the line.
     * </p>
     * @param p0
     * @return 
     */
    public Position relativePosition(Point2D p0);
}
