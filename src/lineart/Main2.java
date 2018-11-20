package lineart;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import lineart.model.Area;
import lineart.model.Coloring;
import lineart.model.Point2D;


/**
 * 
 * 
 * 
 * 
 * 
 * @author noisedriver
 */
public class Main2 {
    
    /**
     * 
     * @see https://stackoverflow.com/questions/33088505/how-to-convert-a-matrix-to-an-image-in-java
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int WIDTH = 8000, HEIGHT = 8000, LINE_WIDTH = 80;
        
        Canvas2 canvas = new Canvas2(WIDTH, HEIGHT, LINE_WIDTH);
        
        try {
            BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_BYTE_INDEXED);
            
            for(int i = 0; i < WIDTH; i++) {
                for(int j = 0; j < HEIGHT; j++) {
                    int a = canvas.getColor(i, j);
                    Color newColor = new Color(a,a,a);
                    image.setRGB(i,j,newColor.getRGB());
                }
            }
            
            File output = new File("GrayScale.jpg");
            ImageIO.write(image, "jpg", output);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static class Canvas2 {

        private final int width;
        private final int height;
        private final int lineWidth;
        private final java.util.List<Area> areas;

        public Canvas2(int width, int height, int lineWidth) {
            assert(width > 0 && height > 0);
            this.width = width;
            this.height = height;
            this.lineWidth = lineWidth;
            this.areas = new LinkedList<>();
            
            // Adding areas...
            this.areas.add(new Area(Coloring.VERTICAL,
                                    new Point2D(0, 0),
                                    new Point2D(0, height),
                                    new Point2D(width / 3, height),
                                    new Point2D(width / 2, 0)));
            this.areas.add(new Area(Coloring.HORIZONTAL,
                                    new Point2D(width / 2, 0),
                                    new Point2D(width / 3, height),
                                    new Point2D(width, height),
                                    new Point2D(width, 0)));
        }

        public lineart.model.Rectangle getBounds() {
            return new lineart.model.Rectangle(this.width, this.height, new Point2D());
        }

        // resolution i,j grid ~ WIDTH x HEIGHT plane
        private Coloring getColoring(int i, int j) {
            Point2D p = new Point2D(i, j);
            for (Area a : this.areas)
                if (a.contains(p)) return a.getColoring();
            // Default :
            return Coloring.VERTICAL;
        }

        public int getColor(int i, int j) {
            if (this.getColoring(i,j) == Coloring.VERTICAL) {
                // Set grid values...
                if (j / this.lineWidth % 2 == 0) return 255;
            } else {
                if (i / this.lineWidth % 2 == 0) return 255;
            }
            return 0;
        }
    }
}
