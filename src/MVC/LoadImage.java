/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ari
 */
class LoadImage {
     BufferedImage img;
 
    public LoadImage(String file) {
       try {
           img = ImageIO.read(new File(file));
       } catch (IOException e) {
           System.out.println("no image");
       }
      
    }
 
}
