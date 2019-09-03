import java.util.TimerTask;

public class Car extends TimerTask {
    int length;
    int width;
    int speed;
    int position;
    int roadID;
    int roadLength;
    int trafficLight;
    String carNr;
    String color = "red";

    public Car(){
        this.length = 6;
        this.width = 3;
        this.speed = 1;
        this.position = 0;
        this.roadID = 1;
        this.carNr = "1";
    }

    /** Method for moving the car */
    @Override
    public void run() {
        Road road = new Road();
        roadLength = road.getLength();
        Robot robot = new Robot();
        trafficLight = robot.getCanDrive();
        System.out.println("carrun trafficlight "+ trafficLight);
        if ((position < roadLength) && (getSpeed() > 0)) {
            position = position + 1;
            System.out.println("Car "+carNr+" drives to length: "+ position+ " out of "+roadLength+
                    " on road: "+roadID);
            }
        else if (position == roadLength) {
            //System.out.println("Car traffic light " + trafficLight);
            if (trafficLight == 0) {
                //System.out.println("Reached traffic light - Current status: Red");
            }
            else if (trafficLight == 1){
                //System.out.println("Reached traffic light - Current status: Green");
                position = 0;
                roadID = 2;
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /** Method for creating car */
    public void buildCar(){
        //spawn car

    }


    /** Method that initializes car movement */
    public void start(){
        speed = 1;
    }

    /** Method for stopping car */
    public void stop(){
        speed = 0;
    }

    /** Method for removing car */
    public void removeCar(){
        //remove car
    }

}
