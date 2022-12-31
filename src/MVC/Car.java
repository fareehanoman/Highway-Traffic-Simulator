package MVC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Car extends Vehicles {

    public Car(int speed, int delay, Driver driver,Point start, Modelable theModel) {
        super(speed, delay,driver,start, theModel);
        length = 45;
        width = 25;
        wheelSize = 6;

    }

    public void paint(Graphics g, int start) {
        LaneChanger();

        g.setColor(Color.red);
        g.fillRect(position.x-start, position.y, length, width);
        g.setColor(Color.black);
        g.fillOval(position.x-start + length/7, position.y - wheelSize*4/5, wheelSize, wheelSize);
        g.fillOval(position.x-start + length* 5/7, position.y - wheelSize*4/5, wheelSize, wheelSize);
        g.fillOval(position.x-start + length/7, position.y + width -  wheelSize*1/5, wheelSize, wheelSize);
        g.fillOval(position.x-start + length* 5/7, position.y + width - wheelSize*1/5, wheelSize, wheelSize);
        
    }

}
