/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ari
 */
public class SportsCar extends Vehicles {

    public SportsCar(int speed, int delay, Driver driver, Point start, Modelable theModel) {
        super(speed, delay, driver, start, theModel);
        length = 65;
        width = 30;
        chooseImage();
        topSpeed = 120;

    }

    @Override
    void paint(Graphics g, int start) {
        LaneChanger();
        g.drawImage(loader.img, position.x - start, position.y, length, width, null);
    }

    private void chooseImage() {
        switch ((int) (Math.random() * 6)) {
            case 0:
                loader = new LoadImage("sportscar.png");
                break;
            case 1:
                loader = new LoadImage("sportscar2.png");
                break;
            case 2:
                loader = new LoadImage("sportscar3.png");
                break;
            case 3:
                loader = new LoadImage("sportscar4.png");
                break;
            case 4:
                loader = new LoadImage("sportscar5.png");
                break;
            case 5:
                loader = new LoadImage("sportscar6.png");
                break;
        }

    }

}
