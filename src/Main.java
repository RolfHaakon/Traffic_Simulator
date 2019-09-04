import java.util.Timer;

public class Main {
    String fileName = "Untitled";


    public static void main(String[] args) {
        Main.start();
    }


    /** Method for starting the simulation */
    public static void start(){
        System.out.println("\nThe car will drive down Road 1, wait for the traffic light to turn green" +
                "before continuing down road 2. After reaching the end of road 2 the car will start from the beginning\n");
        Timer timer = new Timer();
        timer.schedule(new Pulse(),0,1000);
    }
    /** Method for stopping the simulation */
    public void stop(){

    }

    /** Method for initializing editor */
    public void build(){

    }

    /** Method for saving current simulation */
    public void save(){

    }

    /** Method for loading a simulation */
    public void load(){

    }


}
