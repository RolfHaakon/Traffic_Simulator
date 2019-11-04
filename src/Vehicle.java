import java.awt.*;

public class Vehicle {

    int x;
    int y;
    int roadID;

    int length = 0;
    int width = 0;
    int speed = 0;
    Vehicle(int x, int y, int roadID) {
        this.x = x;
        this.y = y;
        this.roadID = roadID;
    }

    //Will use paint method in child classes
    public void paint(Graphics g){

    }

    int getX() {
        return x;
    }
    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    int getSpeed() {
        return speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    int getLength() {
        return length;
    }

    int getRoadID() {
        return roadID;
    }

    void setRoadID(int roadID) {
        this.roadID = roadID;
    }
}
