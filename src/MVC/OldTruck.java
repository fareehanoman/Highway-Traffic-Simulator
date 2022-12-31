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
public class OldTruck extends Vehicles {

    public OldTruck(int speed, int delay, Driver driver, Point start, Modelable theModel) {
        super(speed, delay,driver,start, theModel);
        length = 90;
        width = 45;
        topSpeed = 50;
        loader = new LoadImage("truck.png");
    }

    @Override
    void paint(Graphics g, int start) {
        LaneChanger();
        g.drawImage(loader.img, position.x - start, position.y-7, length, width, null);
    }

}
