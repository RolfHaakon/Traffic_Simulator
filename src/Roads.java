import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Roads extends JPanel {

    private ArrayList<Vehicle> cars = new ArrayList<>();
    private ArrayList<RoadList> roadList = new ArrayList<>();
    private ArrayList<TrafficLightsList> xyTL = new ArrayList<>();
    private ArrayList<RoadConnections> roadConnections = new ArrayList<>();

    Roads(){
            super();
    }

    private void addVehicle(Vehicle v){
        cars.add(v);
    }

    private void addRoad(RoadList xRoad){
        roadList.add(xRoad);
    }


    private void addTL(TrafficLightsList TrafficLightsList){
        xyTL.add(TrafficLightsList);
    }



    public void paintComponent(Graphics g){
            super.paintComponent(g);
        for (Vehicle car : cars) {
            car.paint(g);
        }
        for (RoadList list : roadList) {
            list.paint(g);
        }
        for (TrafficLightsList trafficLightsList : xyTL) {
            trafficLightsList.paint(g);
        }


    }

    void initDraw(){
        // Default x roads - y = 300
        RoadList defRoad1 = new RoadList(0,300,300,300,0,true);
        addRoad(defRoad1);
        RoadList defRoad2 = new RoadList(300,300,600,300,1,true);
        addRoad(defRoad2);
        RoadList defRoad3 = new RoadList(600,300,900,300,2,true);
        addRoad(defRoad3);
        RoadList defRoad4 = new RoadList(900,300,1200,300,3,true);
        addRoad(defRoad4);

        //Default y roads - x = 300
        RoadList defRoad5 = new RoadList(300,0, 300, 300, 4,false);
        addRoad(defRoad5);
        RoadList defRoad6 = new RoadList(300,300, 300, 500, 5,false);
        addRoad(defRoad6);
        RoadList defRoad7 = new RoadList(300,500, 300, 700, 6,false);
        addRoad(defRoad7);

        // Default x road - y = 500
        RoadList defRoad8 = new RoadList(300,500,600,500,7,true);
        addRoad(defRoad8);
        RoadList defRoad9 = new RoadList(600,500,900,500,8,true);
        addRoad(defRoad9);
        RoadList defRoad10 = new RoadList(900,500,1200,500,9,true);
        addRoad(defRoad10);

        //Road connections - If a road does not have 3 connections, the remaining values will be filled with the roadID
        RoadConnections connection1 = new RoadConnections(0,1,5,0);
        roadConnections.add(connection1);
        RoadConnections connection2 = new RoadConnections(1,2,1,1);
        roadConnections.add(connection2);
        RoadConnections connection3 = new RoadConnections(2,3,2,2);
        roadConnections.add(connection3);
        RoadConnections connection4 = new RoadConnections(3,3,3,3);
        roadConnections.add(connection4);
        RoadConnections connection5 = new RoadConnections(5,6,7,5);
        roadConnections.add(connection5);
        RoadConnections connection6 = new RoadConnections(6,6,6,6);
        roadConnections.add(connection6);
        RoadConnections connection7 = new RoadConnections(7,8,7,7);
        roadConnections.add(connection7);
        RoadConnections connection8 = new RoadConnections(8,9,8,8);
        roadConnections.add(connection8);
        RoadConnections connection9 = new RoadConnections(9,9,9,9);
        roadConnections.add(connection9);

        //Default x traffic lights y=300
        TrafficLightsList defTL1 = new TrafficLightsList(300,300,0,false,1);
        addTL(defTL1);
        TrafficLightsList defTL2 = new TrafficLightsList(600, 300,1,true,1);
        addTL(defTL2);
        TrafficLightsList defTL3 = new TrafficLightsList(900, 300, 2, false,1);
        addTL(defTL3);
        TrafficLightsList defTL4 = new TrafficLightsList(1195, 300, 3, true,1);
        addTL(defTL4);

        //Default y traffic lights
        TrafficLightsList defTL5 = new TrafficLightsList(300,0,4,false,0);
        addTL(defTL5);
        TrafficLightsList defTL6 = new TrafficLightsList(300,500,5,false,0);
        addTL(defTL6);
        TrafficLightsList defTL7 = new TrafficLightsList(300,700,6,false,0);
        addTL(defTL7);

        // Default x traffic lights y=500
        TrafficLightsList defTL8 = new TrafficLightsList(600, 500, 7, true,1);
        addTL(defTL8);
        TrafficLightsList defTL9 = new TrafficLightsList(900, 500, 8, true,1);
        addTL(defTL9);
        TrafficLightsList defTL10 = new TrafficLightsList(1195, 500, 9, true,1);
        addTL(defTL10);

        // Default cars
        Car defCar1 = new Car(60,295,0);
        addVehicle(defCar1);
        Car defCar2 = new Car(450,295,2);
        addVehicle(defCar2);
        Car defCar3 = new Car(100,295,0);
        addVehicle(defCar3);

//        Bus defBus1 = new Bus(0,300,0);
//        addVehicle(defBus1);

    }

    private boolean lightStatus(int id){
        TrafficLightsList TrafficLightsList = xyTL.get(id);
        return TrafficLightsList.isRunning();
    }
    void lightChange(){
        for (TrafficLights trafficLights : xyTL) {
            if (trafficLights.running) {
                trafficLights.setRunning(false);
            } else {
                trafficLights.setRunning(true);
            }
        }
    }

    //TODO Split up method & call y traversal or x traversal when needed instead
    void move(){
        for (Vehicle v : cars) {
            RoadList RoadList = roadList.get(v.roadID);

            //If the road is horizontal
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
                    // if collision, set speed 0
                    if (collision(v, roadList1.x1, v.getY())) {
                        v.setSpeed(0);
                        v.setX(v.getX() + v.getSpeed());
                    } else if (!collision(v, roadList1.x1, v.getY())) {
                        v.setX(roadList1.x1);
                        v.setY(roadList1.y1 - 5);
                        v.setSpeed(4);
                        v.setX(v.getX() + v.getSpeed());
                    }
                }
                if (collision(v, (v.getX() + v.getSpeed()), v.getY())) {
                    v.setSpeed(0);
                }
                v.setX(v.getX() + v.getSpeed());
            } else { //If the road is vertical
                v.setSpeed(4);
                // If red light
                if (((v.getY() + v.getLength()) > RoadList.y2) && (!lightStatus(v.roadID))) {
                    v.setSpeed(0);
                }
                // If green light
                if (((v.getY() + v.getLength() > RoadList.y2) && lightStatus(v.roadID))) {
                    v.setSpeed(4);
                    //Choose next road
                    int newR = newRoad(v.getRoadID());
                    v.setRoadID(newR);
                    RoadList roadList1 = roadList.get(v.roadID);
                    // If collision
                    if (collision(v, v.getX(), roadList1.y1)) {
                        v.setSpeed(0);
                    } else if (!collision(v, v.getX(), roadList1.y1)) {
                        v.setX(roadList1.x1);
                        v.setY((roadList1.y1) - 8);
                        v.setSpeed(4);
                    }
                }
                if (collision(v, v.getX(), (v.getY() + v.getSpeed()))) {
                    v.setSpeed(0);
                }
                v.setY(v.getY() + v.getSpeed());
            }
        }
    }

    // Method which determine the new road id
    private Integer newRoad(int ID) {
        int v;
        for (RoadConnections r : roadConnections) {
            if (r.roadID == ID) {
                List<Integer> l1 = new ArrayList<>();
                l1.add(r.c1);
                l1.add(r.c2);
                l1.add(r.c3);
                v = l1.get((int) (Math.random() * 3));
                if ((r.c1 == r.c2) && (r.c2 == r.c3)) {
                    return 0;
                }
                while (v == r.roadID) {
                    v = l1.get((int) (Math.random() * 3));
                }
                return v;
            }
        }
        return 0;
    }

    // Method for detecting collision
    private boolean collision(Vehicle v, int x, int y){
        for (Vehicle c : cars) { //loop through vehicles
            if (y == c.getY() || (x == c.getX())) {  //check vehicles in lanes
                if (!c.equals(v)) { //make sure the vehicle don't collide with itself
                    if (x == (c.getX() - 8)) {
                        return true;
                    }
                    if (y == (c.getY() - 8)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // Method to spawn cars
    void spawnCar() {
        Car defCar10 = new Car(0,295,0);
        addVehicle(defCar10);
    }
}







