package MVC;

public class Globals {

    public static int NumLanes = 3; //number of lanes
    public static int CarsArriving = 250; //number of cars beginning on the road per minute
    public static int ViewPointOne = 100; //the left x of viewpoint 1
    public static int ViewPointTwo = 800; //the left x of viewpoint 2
    public static int ViewPortHeight = 500; //viewport height
    public static int ViewPortWidth = 500; //viewport width
    public static int ViewPointOneEnd = ViewPointOne + ViewPortWidth;
    public static int ViewPointTwoEnd = ViewPointTwo + ViewPortWidth;
    public static int LaneOne = 125;
    public static int LaneSize = 50;

    public static int getNumLanes() {
        return NumLanes;
    }

    public static int getLane(int n) {
        return (LaneOne + (LaneSize * (n - 1)));
    }

    public static void setLaneOneAndSize(int laneOne, int size) {
        LaneOne = laneOne;
        LaneSize = size;
    }

    public static void setNumLanes(int n) {
        NumLanes = n;

    }

    public static int getCarsArriving() {
        return CarsArriving;
    }

    public static void setCarsArriving(int n) {
        CarsArriving = n;

    }

    public static int getViewPoint(int view) {
        if (view == 1) {
            return ViewPointOne;
        } else {
            return ViewPointTwo;
        }
    }

    public static int getViewPointEnd(int view) {
        if (view == 1) {
            return ViewPointOneEnd;
        } else {
            return ViewPointTwoEnd;
        }
    }

    public static int getViewPortHeight() {
        return ViewPortHeight;
    }

    public static void setViewPortHeight(int n) {
        ViewPortHeight = n;
    }

    public static int getViewPortWidth() {
        return ViewPortWidth;
    }

    public static void setViewPortWidth(int n) {
        ViewPortWidth = n;
    }

    public static String output() {
        String returnMe = "I am the Globals";

        returnMe += ("\nlane = " + getNumLanes());
        returnMe += ("\narriving = " + getCarsArriving());

        return returnMe;
    }

}
