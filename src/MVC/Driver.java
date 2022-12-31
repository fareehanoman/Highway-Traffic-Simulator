/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author christopherbarnes
 */
public class Driver {
    
    int preferredSpeed;
    double accelAmmount;
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
