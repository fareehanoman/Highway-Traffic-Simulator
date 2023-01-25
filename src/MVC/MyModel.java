package MVC;
import java.awt.Point;
import java.util.ArrayList;

class MyModel implements Modelable {

    VehicleList theVehicles;
    int t;          //t is for stats
    int count;      //counts all the vehicles in arraylist

    public MyModel() {
        init();     // init method is a predefine method to initialize an object after its creation.
    }

    public int getT() {
        return t;       //displays in console
    }

    public void init() {
        t = 1; 
        count = 25;
        theVehicles = new VehicleList();
    }

    //This is the method that generates random vehicles on the view through switch case and Math.random
    public Vehicles randomVehicle() {
        Vehicles v = null;
        switch ((int) (Math.random() * 8)) {
            case 0:
                v = new OldTruck(10, 0, new Driver((int) (Math.random() * 20) + 55, Math.random() + 0.2), laneChooser(), this);
                break;
            case 1:
                v = new MotorCycle(10, 0, new Driver((int) (Math.random() * 20) + 55, Math.random() + 0.2), laneChooser(), this);
                break;
            case 2:
                v = new Car(10, 0, new Driver((int) (Math.random() * 20) + 55, Math.random() + 0.2), laneChooser(), this);
                break;
            case 3:
                v = new Truck(10, 0, new Driver((int) (Math.random() * 20) + 55, Math.random() + 0.2), laneChooser(), this);
                break;
            case 4:
                v = new Police(10, 0, new Driver((int) (Math.random() * 20) + 55, Math.random() + 0.2), laneChooser(), this);
                break;
            case 5:
            case 6:
            case 7:
                v = new SportsCar(10, 0, new Driver((int) (Math.random() * 20) + 55, Math.random() + 0.2), laneChooser(), this);
                break;
        }
        return v;
    }

    public Point laneChooser() {
        int lane = (int) (Math.random() * 3) + 1;
        Point start;
        if (lane == 1) {
            start = new Point(0, Globals.getLane(1) + 10);
        } else if (lane == 2) {
            start = new Point(0, Globals.getLane(2) + 10);
        } else {
            start = new Point(0, Globals.getLane(3) + 10);
        }
        return start;
    }

    public void step() {
        t++; 
        count++;

        if (count / 15 ==1) {
            theVehicles.add(randomVehicle());
            count = 0;
        }
        for (Vehicles v : theVehicles) {
//            if(t % 10 == 0) {
            v.isBehind(theVehicles);

//            }
            if (v.delay < t) {
                v.accelerate();
                v.setPosition((int) (v.speed));
                v.checkLane();
                System.out.println("vehicle " + theVehicles.indexOf(v) + v.behind + v.laneIn+"\n");
            } else {
                return;
            }

        }

    }

    public String toString() {
        String returnMe = "";
        returnMe += "\n\nMyModel! t=" + t;
        return returnMe;
    }

    //method that helps to view vehicle 
    public VehicleList viewSees(int begin, int end) {
        VehicleList viewVehicles = new VehicleList();
        for (Vehicles v : theVehicles) {
            if (v.position.x + v.length >= begin && v.position.x <= end) {
                viewVehicles.add(v);
            }
        }
        return viewVehicles;
    }
}
