package MVC;

import java.awt.Point;
import java.util.ArrayList;

class MyModel implements Modelable {

    VehicleList theVehicles;
    int t;
    int count;

    public MyModel() {
        init();
    }

    public int getT() {
        return t;
    }

    public void init() {
        t = 1;
        count = 25;
        theVehicles = new VehicleList();
//        for (int i = 0; i < 1; i++) {
//          theVehicles.add(new Car(60, i));
//        }
//        
        //for (int i = 0; i < 3; i++) {
//          theVehicles.add(new Truck(10, 1,new Driver((int)(Math.random()*20)+55,Math.random()+0.2),laneChooser()));
        //theVehicles.add(new Truck(100, 1,new Driver((int)(Math.random()*20)+55,Math.random()+0.2),laneChooser()));

        //}
    }

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
        t++; // okay, okay, it's the least I can do!
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
