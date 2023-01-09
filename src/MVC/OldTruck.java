package MVC;
import java.awt.Graphics;
import java.awt.Point;

public class OldTruck extends Vehicles {

    public OldTruck(int speed, int delay, Driver driver, Point start, Modelable theModel) {
        super(speed, delay,driver,start, theModel);
        //truck dimensions
        length = 90;
        width = 45;
        //truck speed
        topSpeed = 50;
        //load truck image
        loader = new LoadImage("truck.png");
    }

    @Override
    void paint(Graphics g, int start) {
        LaneChanger();
        //The method paint() gives us access to an object of type Graphics class 
        g.drawImage(loader.img, position.x - start, position.y-7, length, width, null);
    }

}
