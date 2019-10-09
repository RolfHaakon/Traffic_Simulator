import javax.swing.*;

public class Car{
    int length;
    int width;
    int speed;
    int carID;
    int roadLength;
    static int roadID;
    static int position;


    public Car(int carID, int speed){
        this.carID = carID;
        this.length = 3;
        this.width = 1;
        this.speed = speed;
    }


    /** Method for moving the car */
    public void moveForward() {
        if (roadID == 0){
            //roadLength = Road.road0Length;
        }
        else if (roadID == 1){
            //roadLength = Road.road1Length;
        }

        if (position == roadLength &&  roadID == 1){
            positionPrint();
            System.out.println("\nCar reached end of road 2, starting from the position 0 - road 0 again\n");
            roadID = 0;
            position = 0;
        }

        if ((position < roadLength) && (getSpeed() > 0)) {
            positionPrint();
            position = position + 1;
            }
        else if (position == roadLength) {
            if (!Robot.TL1) {
                redLightPrint();
            }
            else if (Robot.TL1){
                greenLightPrint();
                position = 0;
                roadID = 1;
            }
        }
    }

    /** Method for printing the position of the car */
    public void positionPrint(){
         System.out.println("Car "+" position is: "+ position+ "/"+roadLength+ " on road:"+roadID);;
    }

    /** Method for printing traffic light status: Red & the position of the car */
    public void redLightPrint(){
         System.out.println("Red light - Position is: "+position+"/"+roadLength+" on road : "+roadID);
    }

    /** Method for printing traffic light status: Green */
    public void greenLightPrint(){
        System.out.println("Green light!");
    }

    /** Getter for speed */
    public int getSpeed() {
        return speed;
    }

    /** Setter for speed */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    /** Method that initializes car movement */
    public void start(){
        speed = 1;
    }
    /** Method for stopping car */
    public void stop(){
        speed = 0;
    }

}
