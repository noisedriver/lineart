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
}
