public class Car{
    int length;
    int width;
    int speed;
    int roadLength;
    static int roadID;
    static int position;


    public Car(){
        this.length = 6;
        this.width = 3;
        this.speed = 1;
    }


    /** Method for moving the car
     * @return*/
    public void moveForward() {
        if (roadID == 0){
            roadLength = Road.road0Length;
        }
        else if (roadID == 1){
            roadLength = Road.road1Length;
        }

        if (position == roadLength &&  roadID == 1){
            System.out.println("Car "+" position is: "+ position+ "/"+roadLength+ " on road: "+roadID);
            System.out.println("Car reached end of road 2, starting from the position 0 - road 0 again");
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

    public void positionPrint(){
         System.out.println("Car "+" position is: "+ position+ "/"+roadLength+ " on road: "+roadID);;
    }

    public void redLightPrint(){
         System.out.println("Red light - Position is: "+position+"/"+roadLength+"on road: "+roadID);
    }

    public void greenLightPrint(){
        System.out.println("Green light!");
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
