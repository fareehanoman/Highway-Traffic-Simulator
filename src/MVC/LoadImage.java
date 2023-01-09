package MVC;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class LoadImage {
     //BufferedImage is a subclass of Image it can be rendered by the Graphics and Graphics2D methods that accept an Image parameter
     BufferedImage img;
 
    public LoadImage(String file) {
       //EXCEPTION HANDLING 
       try {
            //If file is not present or is not an image file
           img = ImageIO.read(new File(file));
       } catch (IOException e) {
           System.out.println("no image");
       } 
    }}
