package MVC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Car extends Vehicles {

    public Car(int speed, int delay, Driver driver,Point start, Modelable theModel) {
		//super() is used to call parent class constructor
        super(speed, delay,driver,start, theModel);
		//car dimensions
        length = 45;
        width = 25;
        wheelSize = 6;

    }

    public void paint(Graphics g, int start) {
        LaneChanger();//method in Vehicles that tells when to change lane
        //car color is red
        g.setColor(Color.red);
		//dimensions of red car
        g.fillRect(position.x-start, position.y, length, width);
		//car tyre color is black
        g.setColor(Color.black);
		//wheel dimensions of car at x and y coordinates
        g.fillOval(position.x-start + length/7, position.y - wheelSize*4/5, wheelSize, wheelSize);
        g.fillOval(position.x-start + length* 5/7, position.y - wheelSize*4/5, wheelSize, wheelSize);
        g.fillOval(position.x-start + length/7, position.y + width -  wheelSize*1/5, wheelSize, wheelSize);
        g.fillOval(position.x-start + length* 5/7, position.y + width - wheelSize*1/5, wheelSize, wheelSize);
        
    }

}
