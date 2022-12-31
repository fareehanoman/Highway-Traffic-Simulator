package MVC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

abstract class Vehicles {

    Modelable theModel;
    boolean isSemi;
    double speed;
    Point position;
    int width;
    int length;
    int delay;
    int wheelSize;
    int laneIn;
    Driver driver;
    Point start;
    boolean behind = false;
    Vehicles followVehicle;
    boolean canChangeLeft = false;
    boolean canChangeRight = false;
    int changing = 0;
    int topSpeed;
    LoadImage loader;

    Vehicles(int speed, int delay, Driver driver, Point start, Modelable theModel) {
        this.isSemi = false;
        this.speed = ConvertSpeed(speed);
        position = start;
        this.delay = delay * 25;
        this.driver = driver;
        this.start = start;
        this.theModel = theModel;
        if (start.y == 135) {
            laneIn = 1;
        } else if (start.y == 185) {
            laneIn = 2;
        } else if (start.y == 235) {
            laneIn = 3;

        }

    }

    public void isBehind(VehicleList list) {
        for (Vehicles v : list) {
            if (v.laneIn == laneIn && v != this && (v.position.x > this.position.x)) {
                if (v.position.x - (this.position.x + this.length) <= this.driver.followDistance()) {
                    behind = true;
                    followVehicle = v;
                    break;
                } else {
                    behind = false;
                    followVehicle = null;
                }
            }
        }

    }

    public void LaneChanger() {
        if (canChangeLeft && changing <= 5) {
            position.y -= 8;
            changing++;
            if (changing == 5) {
                if (laneIn == 2) {
                    laneIn = 1;
                } 
                else if (laneIn == 3) {
                    laneIn = 2;
                }
            }
        } else if (canChangeRight && changing <= 5) {
            position.y += 8;
            changing++;
            if (changing == 5) {
                if (laneIn == 1) {
                    laneIn = 2;
                } 
                else if (laneIn == 2) {
                    laneIn = 3;
                }
            }
        } else {
            changing = 0;
            canChangeLeft = false;
            canChangeRight = false;
        }
    }

    public void checkLane() {
        if (start.y == 135) {
            laneIn = 1;
        } else if (start.y == 185) {
            laneIn = 2;
        } else if (start.y == 235) {
            laneIn = 3;

        }
    }

    public void accelerate() {

        if (behind) {
            if (!driver.follow) {
                changeLanes();
            }
            if (speed > followVehicle.speed) {
                speed = speed - 2 * driver.accelAmmount;
            }

        } else {
            if (pTom(speed) < driver.preferredSpeed) {
                if (ConvertSpeed(driver.preferredSpeed) - speed < driver.accelAmmount) {
                    speed = ConvertSpeed(driver.preferredSpeed);
                } else {
                    speed = speed + driver.accelAmmount;
                }
            } else if (pTom(speed) > driver.preferredSpeed) {
                if (speed - ConvertSpeed(driver.preferredSpeed) < driver.accelAmmount) {
                    speed = ConvertSpeed(driver.preferredSpeed);
                } else {
                    speed = speed - driver.accelAmmount;
                }
            }
        }
    }

    Point getPosition() {
        return position;
    }

    abstract void paint(Graphics g, int start);

    void setPosition(int i) {
        position.x += i;
    }

    private double ConvertSpeed(int speed) {
        return speed / 3.6;
    }

    private double pTom(double speed) {
        return speed * 3.6;
    }

    private void changeLanes() {
        VehicleList changeLanesList;
        changeLanesList = theModel.viewSees(this.position.x, this.position.x + 50);

        for (Vehicles v : changeLanesList) {
            switch (this.laneIn) {
                case 1:
                    canChangeLeft = false;
                    if (v.laneIn == 2) {
                        canChangeRight = false;
                        return;
                    } else {
                        canChangeRight = true;
                    }
                    break;

                case 2:
                    if ((v.laneIn == 1) && (v.laneIn == 3)) {
                        canChangeLeft = false;
                        canChangeRight = false;
                        return;
                    } else if (v.laneIn == 1) {
                        canChangeLeft = false;
                        canChangeRight = true;
                        return;
                    } else if (v.laneIn == 3) {
                        canChangeRight = false;
                        canChangeLeft = true;
                        return;
                    }
                    break;

                case 3:
                    canChangeRight = false;
                    if (v.laneIn == 2) {
                        canChangeLeft = false;
                        return;
                    } else {
                        canChangeLeft = true;
                    }
                    break;

            }
        }
    }

}
