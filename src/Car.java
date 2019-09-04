public class Car{
    int length;
    int width;
    int speed;
    int roadID;
    int roadLength;
    String carNr;


    public Car(){
        this.length = 6;
        this.width = 3;
        this.speed = 1;
        this.roadID = 1;
        this.carNr = "1";
    }

    public int getRoadID() {
        return roadID;
    }

    public void setRoadID(int roadID) {
        this.roadID = roadID;
    }


    /** Method for moving the car
     * @return*/
    public int moveForward(int position) {
        roadLength = 3;
        if ((position < roadLength) && (getSpeed() > 0)) {
            System.out.println("Car "+carNr+" drives to length: "+ position+ " out of "+roadLength+ " on road: "+roadID);
            position = position + 1;
            }
        else if (position == roadLength) {
            if (!Robot.TL1) {
                System.out.println("Waiting for traffic light - Current status: Red");
            }
            else if (Robot.TL1){
                System.out.println("Reached traffic light - Current status: Green");
                position = position + 1;
            }
        }
        System.out.println(position);
        return position;
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
