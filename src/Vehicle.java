import java.awt.*;

public class Vehicle {

    int x;
    int y;
    int roadID;

    int length = 0;
    int width = 0;
    int speed = 0;
    public Vehicle(int x, int y, int roadID) {
        this.x = x;
        this.y = y;
        this.roadID = roadID;
    }

    //Will use paint method in child classes
    public void paint(Graphics g){

    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLength() {
        return length;
    }

    public int getRoadID() {
        return roadID;
    }

    public void setRoadID(int roadID) {
        this.roadID = roadID;
    }
}
