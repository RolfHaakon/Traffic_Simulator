import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Roads extends JPanel {

    ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
    ArrayList<xRoads> horizontalRoads = new ArrayList<xRoads>();
    ArrayList<xTrafficLights> horizontalTL = new ArrayList<xTrafficLights>();
    ArrayList<yRoads> verticalRoads = new ArrayList<yRoads>();
    ArrayList<RoadConnections> roadConnections = new ArrayList<RoadConnections>();


    final int MAP_WIDTH = 1200;
    final int ROAD_LENGTH = 300;
    final int XLANE_ONE_Y = 300;
    final int XLANE_TWO_Y = 500;


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
            for (int i = 0; i < verticalRoads.size(); i++){
                verticalRoads.get(i).paint(g);
            }
            for (int i = 0; i < horizontalTL.size(); i++){
                horizontalTL.get(i).paint(g);
            }


    }

    public void initDraw(){

        // Default x roads
        xRoads defRoad1 = new xRoads(0,XLANE_ONE_Y,300,XLANE_ONE_Y,0);
        addxRoad(defRoad1);
        xRoads defRoad2 = new xRoads(300,XLANE_ONE_Y,600,XLANE_ONE_Y,1);
        addxRoad(defRoad2);
        xRoads defRoad3 = new xRoads(600,XLANE_ONE_Y,900,XLANE_ONE_Y,2);
        addxRoad(defRoad3);
        xRoads defRoad4 = new xRoads(900,XLANE_ONE_Y,1200,XLANE_ONE_Y,3);
        addxRoad(defRoad4);

        //Default y roads
        yRoads defRoady1 = new yRoads(300,300, 300, 500, 4);
        addyRoad(defRoady1);
        yRoads defRoady2 = new yRoads(300,500, 300, 700, 5);
        addyRoad(defRoady2);
        yRoads defRoady3 = new yRoads(300,0, 300, 300, 6);
        addyRoad(defRoady3);

        //Road connections
        RoadConnections connection1 = new RoadConnections(0,1,4,5);
        roadConnections.add(connection1);


        //Default x traffic lights
        xTrafficLights defTL1 = new xTrafficLights(300,300,0,false);
        addxTL(defTL1);
        xTrafficLights defTL2 = new xTrafficLights(600, 300,1,false);
        addxTL(defTL2);
        xTrafficLights defTL3 = new xTrafficLights(900, 300, 2, true);
        addxTL(defTL3);

        //Default y traffic lights


        Car defCar1 = new Car(40,300,0);
        addVehicle(defCar1);

        Bus defBus1 = new Bus(0,300,0);
        addVehicle(defBus1);

    }

    public boolean lightStatus(int id){
        xTrafficLights xTrafficLights = horizontalTL.get(id);
        return xTrafficLights.isRunning();
    }
    public void lightChange(){
        for (int i = 0; i < horizontalTL.size(); i++ ){
            TrafficLights trafficLights = horizontalTL.get(i);
            if (trafficLights.running){
                trafficLights.setRunning(false);
            } else {
                trafficLights.setRunning(true);
            }
        }
    }


    public void move(){
        for (int i = 0; i < cars.size(); i++) {
            Vehicle v = cars.get(i);
            xRoads xRoads = horizontalRoads.get(v.roadID);
            //xTrafficLights xTrafficLights = horizontalTL.get(v.roadID);
            System.out.println(xRoads.x2);
            if (((v.getX() + v.getLength()) > xRoads.x2) && (!lightStatus(v.roadID))) {
                v.setSpeed(0);
            }
            if (((v.getX() + v.getLength() > xRoads.x2) && lightStatus(v.roadID))){
                v.setSpeed(5);
                //Choose next road
                newRoad(v.getRoadID());

                v.setRoadID(1);
                v.setX(v.getX() + v.getSpeed());
            }
            v.setX(v.getX() + v.getSpeed());
        }
    }

    private void newRoad(int ID) {

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




