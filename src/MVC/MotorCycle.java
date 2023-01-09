package MVC;

import java.awt.Graphics;
import java.awt.Point;
public class MotorCycle extends Vehicles {
    
    public MotorCycle(int speed, int delay, Driver driver, Point start,Modelable theModel) {
        super(speed, delay,driver,start, theModel);
        //the length and width of motorcycle 
        length = 30;
        width = 15;
        loader = new LoadImage("motorcycle.png");
        //speed of motorcycle
        topSpeed = 80;
    }

    @Override
    void paint(Graphics g, int start) {
        LaneChanger();
        g.drawImage(loader.img, position.x-start, position.y+10, length, width, null);   
    }
}
