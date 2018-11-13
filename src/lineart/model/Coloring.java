package lineart.model;

/**
 *
 * @author Joris
 */
public enum Coloring {
    VERTICAL, HORIZONTAL;
    
    /**
     *
     * @param coloring
     * @return
     */
    public static Coloring swapColoring(Coloring coloring) {
        return coloring == Coloring.HORIZONTAL ? Coloring.VERTICAL : Coloring.HORIZONTAL;
    }
}
