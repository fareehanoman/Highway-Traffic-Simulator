package MVC;
public class Driver {
    
    int preferredSpeed;
    double accelAmmount;
    //follows distance of 75 spaces between vehicles
    private int followDistance = 75;
    int preferredLane;
    boolean follow = false;
    
    Driver(int speed,double accelAmount){
        preferredSpeed = speed;
        this.accelAmmount = accelAmount;
    }

    int followDistance() {
        return followDistance;
    }
}
