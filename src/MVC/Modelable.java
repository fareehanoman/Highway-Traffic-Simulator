package MVC;
import java.util.ArrayList;

/**
 * The interface our model will implement
 * Add all the the methods that will be sent to the Model
 */

public interface Modelable {
    public void step();
    public void init();
    public int getT();
//all the vehicles in VehicleList are called    
    public VehicleList viewSees(int begin, int end);
}
