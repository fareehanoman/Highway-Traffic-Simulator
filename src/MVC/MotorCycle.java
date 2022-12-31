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
public class MotorCycle extends Vehicles {

   
    
    public MotorCycle(int speed, int delay, Driver driver, Point start,Modelable theModel) {
        super(speed, delay,driver,start, theModel);
        length = 30;
        width = 15;
        loader = new LoadImage("motorcycle.png");
        topSpeed = 80;
    }

    @Override
    void paint(Graphics g, int start) {
        LaneChanger();
        
        g.drawImage(loader.img, position.x-start, position.y+10, length, width, null);   
    }
    
}
