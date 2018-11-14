package lineart.model;

/**
 * Coloring type, either horizontal or vertical.
 * @author noisedriver
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
