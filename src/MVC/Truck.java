package MVC;

import java.awt.Graphics;
import java.awt.Point;

public class Truck extends Vehicles{
     public Truck(int speed, int delay, Driver driver,Point start, Modelable theModel) {
        super(speed, delay,driver,start, theModel);
        length = 140;
        width = 45;
        wheelSize = 9;
        topSpeed = 65;
        loader = new LoadImage("firetruck.png");
    }

    public void paint(Graphics g, int start) {
        LaneChanger();
        g.drawImage(loader.img, position.x-start, position.y-5, length, width, null);
    }
}
