package lineart;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import lineart.model.Canvas;
import lineart.model.Line2D;
import lineart.model.Point2D;


/**
 *
 * @author noisedriver
 */
public class Main {
    
    /**
     * 
     * @see https://stackoverflow.com/questions/33088505/how-to-convert-a-matrix-to-an-image-in-java
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int WIDTH = 1024, HEIGHT = 1024, LINE_WIDTH = 5;
        
        Canvas canvas = new Canvas(WIDTH, HEIGHT, LINE_WIDTH);
        canvas.addLine(new Line2D(new Point2D(50, 100)));
        
        try {
            BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_BYTE_INDEXED);
            
            for(int i = 0; i < WIDTH; i++) {
                for(int j = 0; j < HEIGHT; j++) {
                    int a = canvas.getColor(i, j);
                    Color newColor = new Color(a,a,a);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            
            File output = new File("GrayScale.jpg");
            ImageIO.write(image, "jpg", output);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
