package MVC;

public class Statistics {

    public int firstEnd = Globals.getViewPointEnd(1);
    public int secondEnd = Globals.getViewPointEnd(2);
    Modelable theModel;
    ViewFrame theFrame;
    VehicleList theVehicles;
    int view;
    int firstEndCount = 0;
    int secondEndCount = 0;
    String firstString = "";
    String secondString = "";

    public void Stats() {
        for (Vehicles v : theVehicles) {
            if (v.position.x == firstEnd) {
                firstEndCount++;
                firstString = " " + firstEndCount;
                System.out.println("Cars that passed through first view = " + firstEndCount);
            } 
            else if (v.position.x == secondEnd) {
                secondEndCount++;
                secondString = "" + secondEndCount;
                System.out.println("Cars that passed through second view = " + secondEndCount);
            }
        }
    }
}
