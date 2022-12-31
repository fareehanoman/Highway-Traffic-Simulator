/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Ari
 */
public class Police extends Vehicles {

    public Police(int speed, int delay, Driver driver, Point start, Modelable theModel) {
        super(speed, delay,driver,start, theModel);
        length = 80;
        width = 35;
        topSpeed = 150;
        loader = new LoadImage("policecar.png");
    }

    @Override
    void paint(Graphics g, int start) {
        LaneChanger();
         g.drawImage(loader.img, position.x-start, position.y, length, width, null);
    }
    
}
