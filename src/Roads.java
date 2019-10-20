import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Roads extends JPanel {

    ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
    ArrayList<xRoads> horizontalRoads = new ArrayList<xRoads>();
    ArrayList<xTrafficLights> horizontalTL = new ArrayList<xTrafficLights>();


    ArrayList<yRoads> verticalRoads = new ArrayList<yRoads>();
    final int MAP_WIDTH = 1200;
    final int ROAD_LENGTH = 300;
    final int HLANE_ONE_Y = 300;


    public Roads(){
            super();
    }

    public void addVehicle(Vehicle v){
        cars.add(v);
    }

    public void addxRoad(xRoads xRoad){
        horizontalRoads.add(xRoad);
    }
    public void addyRoad(yRoads yRoad){
        verticalRoads.add(yRoad);
    }

    public void addxTL(xTrafficLights xTrafficLights){
        horizontalTL.add(xTrafficLights);
    }

    public void paintComponent(Graphics g){
            super.paintComponent(g);
            for (int i = 0; i < cars.size(); i++){
                cars.get(i).paint(g);
            }
            for (int i = 0; i < horizontalRoads.size(); i++){
                horizontalRoads.get(i).paint(g);
            }
            for (int i = 0; i < horizontalTL.size(); i++){
                horizontalTL.get(i).paint(g);
            }


    }

    public void initDraw(){
        xRoads defRoad1 = new xRoads(0,HLANE_ONE_Y,ROAD_LENGTH,HLANE_ONE_Y,0);
        addxRoad(defRoad1);

        xTrafficLights defTL1 = new xTrafficLights(300,300,false);
        addxTL(defTL1);

        Car defCar1 = new Car(40,300);
        addVehicle(defCar1);

        Bus defBus1 = new Bus(0,300);
        addVehicle(defBus1);

    }


    public void move(){
        for (int i = 0; i < cars.size(); i++) {
            Vehicle v = cars.get(i);
            v.setX(v.getX() + v.getSpeed());
            if (v.getX() > MAP_WIDTH) {
                v.setX(0);
            }
        }
    }

    }


//    public boolean collision(int x, int y, int len, Vehicle v){
//        for (int i = 0; i <cars.size();i++){ //loop through vehicles
//            Vehicle c = cars.get(i);
//            if (y == c.getY() || (x == c.getX())) {  //check vehicles in X lane
//                if (c.equals(v) == false) { //make sure the vehicle don't collide with itself
//                    if (v.getX() < c.getX() + c.getLength() + 5 && //check each vehicles left side is to others right side
//                            v.getX() + v.getLength() +5 > c.getX()) { //check each vehicles right side to others right side.
//                        return true; // return true if collision
//                    }
//                    if (c.equals(v) == false) { // check vehicles in Y lane8
//                        if (v.getY() < v.getX() + c.getLength() + 5 &&
//                        v.getY() + v.getLength() + 5 > c.getY()) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }




