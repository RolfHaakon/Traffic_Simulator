import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Roads extends JPanel {

    ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
    ArrayList<RoadList> roadList = new ArrayList<RoadList>();
    ArrayList<TrafficLightsList> horizontalTL = new ArrayList<TrafficLightsList>();
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

    public void addRoad(RoadList xRoad){
        roadList.add(xRoad);
    }


    public void addxTL(TrafficLightsList TrafficLightsList){
        horizontalTL.add(TrafficLightsList);
    }



    public void paintComponent(Graphics g){
            super.paintComponent(g);
            for (int i = 0; i < cars.size(); i++){
                cars.get(i).paint(g);
            }
            for (int i = 0; i < roadList.size(); i++){
                roadList.get(i).paint(g);
            }
            for (int i = 0; i < horizontalTL.size(); i++){
                horizontalTL.get(i).paint(g);
            }


    }

    public void initDraw(){

        // Default x roads
        RoadList defRoad1 = new RoadList(0,XLANE_ONE_Y,300,XLANE_ONE_Y,0,true);
        addRoad(defRoad1);
        RoadList defRoad2 = new RoadList(300,XLANE_ONE_Y,600,XLANE_ONE_Y,1,true);
        addRoad(defRoad2);
        RoadList defRoad3 = new RoadList(600,XLANE_ONE_Y,900,XLANE_ONE_Y,2,true);
        addRoad(defRoad3);
        RoadList defRoad4 = new RoadList(900,XLANE_ONE_Y,1200,XLANE_ONE_Y,3,true);
        addRoad(defRoad4);

        //Default y roads
        RoadList defRoad5 = new RoadList(300,0, 300, 300, 4,false);
        addRoad(defRoad5);
        RoadList defRoad6 = new RoadList(300,300, 300, 500, 5,false);
        addRoad(defRoad6);
        RoadList defRoad7 = new RoadList(300,500, 300, 700, 6,false);
        addRoad(defRoad7);




        //Road connections - If a road does not have 3 connections, the remaining values will be filled with the roadID
        RoadConnections connection1 = new RoadConnections(0,1,5,0);
        roadConnections.add(connection1);
        RoadConnections connection2 = new RoadConnections(1,2,1,1);
        roadConnections.add(connection2);
        RoadConnections connection3 = new RoadConnections(2,3,2,2);
        roadConnections.add(connection3);
        RoadConnections connection4 = new RoadConnections(3,3,3,3);
        roadConnections.add(connection4);

        //Default x traffic lights
        TrafficLightsList defTL1 = new TrafficLightsList(300,300,0,false,1);
        addxTL(defTL1);
        TrafficLightsList defTL2 = new TrafficLightsList(600, 300,1,true,1);
        addxTL(defTL2);
        TrafficLightsList defTL3 = new TrafficLightsList(900, 300, 2, false,1);
        addxTL(defTL3);
        TrafficLightsList defTL4 = new TrafficLightsList(1195, 300, 3, true,1);
        addxTL(defTL4);

        //Default y traffic lights
        TrafficLightsList defTL5 = new TrafficLightsList(300,500,4,false,0);
        addxTL(defTL5);
        TrafficLightsList defTL6 = new TrafficLightsList(300,700,5,false,0);
        addxTL(defTL6);

        Car defCar1 = new Car(60,295,0, 'e');
        addVehicle(defCar1);

        Car defCar2 = new Car(450,295,2, 'e');
        addVehicle(defCar2);

        Car defCar3 = new Car(100,295,0, 'e');
        addVehicle(defCar3);

//        Bus defBus1 = new Bus(0,300,0);
//        addVehicle(defBus1);

    }

    public boolean lightStatus(int id){
        TrafficLightsList TrafficLightsList = horizontalTL.get(id);
        return TrafficLightsList.isRunning();
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
            RoadList RoadList = roadList.get(v.roadID);
            //xTrafficLights xTrafficLights = horizontalTL.get(v.roadID);

            if (RoadList.isX) {
                v.setSpeed(4);
                if (((v.getX() + v.getLength()) > RoadList.x2) && (!lightStatus(v.roadID))) {
                    v.setSpeed(0);

                }
                if (((v.getX() + v.getLength() > RoadList.x2) && lightStatus(v.roadID))) {
                    v.setSpeed(4);
                    //Choose next road
                    int newR = newRoad(v.getRoadID());
                    v.setRoadID(newR);
                    RoadList roadList1 = roadList.get(v.roadID);
                    if (collision(v, roadList1.x1, v.getY())) {
                        v.setSpeed(0);
                        v.setX(v.getX() + v.getSpeed());
//                    System.out.println("COLLISION Error 1");
                    } else if (!collision(v, roadList1.x1, v.getY())) {
                        v.setX(roadList1.x1);
                        v.setSpeed(4);
                        v.setX(v.getX() + v.getSpeed());
                    }
                }
                if (collision(v, (v.getX() + v.getSpeed()), v.getY())) {
                    v.setSpeed(0);
//                System.out.println("COLLISION Error 2");
                }
                v.setX(v.getX() + v.getSpeed());
            } else {
                v.setSpeed(4);
                if (((v.getY() + v.getLength()) > RoadList.y2) && (!lightStatus(v.roadID))) {
                    v.setSpeed(0);
                }
                if (((v.getY() + v.getLength() > RoadList.y2) && lightStatus(v.roadID))) {
                    v.setSpeed(4);
                    //Choose next road
                    int newR = newRoad(v.getRoadID());
                    v.setRoadID(newR);
                    RoadList roadList1 = roadList.get(v.roadID);
                    if (collision(v, roadList1.x1, roadList1.y1)) {
                        v.setSpeed(0);
//                        v.setX(v.getX() + v.getSpeed());
//                    System.out.println("COLLISION Error 1");
                    } else if (!collision(v, v.getX(), roadList1.y1)) {
                        v.setX(roadList1.x1);
                        v.setY(roadList1.y1);
                        v.setSpeed(4);
                    }
                }
                if (collision(v, (v.getX() + v.getSpeed()), v.getY())) {
                    v.setSpeed(0);
//                System.out.println("COLLISION Error 2");
                }
                v.setY(v.getY() + v.getSpeed());
            }
            //When the speed is determined, make move
//            v.setX(v.getX() + v.getSpeed());
        }
    }

    private Integer newRoad(int ID) {
        int v;
        for (int i = 0; i < roadConnections.size(); i++){
            RoadConnections r = roadConnections.get(i);
            if (r.roadID == ID) {
                List<Integer> l1 = new ArrayList<Integer>();
                l1.add(r.c1);
                l1.add(r.c2);
                l1.add(r.c3);
                v = l1.get((int)(Math.random()*3));
                if ((r.c1 == r.c2) && (r.c2 == r.c3)) {
                    System.out.println("backtostart");
                    return 0;
                }
                while (v == r.roadID) {
                    v = l1.get((int)(Math.random()*3));
                    System.out.println("Reroll " +v);
                }
                System.out.println("V ==="+v);
                return v;
            }
        }
        return 0;
    }

    public boolean collision(Vehicle v, int x, int y){
        for (int i = 0; i <cars.size();i++){ //loop through vehicles
            Vehicle c = cars.get(i);
            if (y == c.getY() || (x == c.getX())) {  //check vehicles in X lane
                if (c.equals(v) == false) { //make sure the vehicle don't collide with itself
                    if (x == (c.getX()-8)){
//                        System.out.println("COLLISION X - TRUE");
                        return true;
                    }
//                    if (v.getX() < c.getX() + c.getLength() + 5 && //check each vehicles left side is to others right side
//                            v.getX() + v.getLength() +5 > c.getX()) { //check each vehicles right side to others right side.
//                        System.out.println("COLLISION X - TRUE");
//                        return true; // return true if collision
//                    }
//                    if (c.equals(v) == false) { // check vehicles in Y lane8
//                        if (v.getY() < v.getX() + c.getLength() + 5 &&
//                                v.getY() + v.getLength() + 5 > c.getY()) {
//                            System.out.println("COLLISION Y - TRUE");
//                            return true;
//                        }
//                    }
                }
            }
        }
        return false;
    }


    public void spawnCar() {
        Car defCar10 = new Car(40,295,0, 'e');
        addVehicle(defCar10);
    }
}







