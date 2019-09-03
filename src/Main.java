import java.util.Timer;

public class Main {
    String fileName = "Untitled";


    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Car(), 0, 1000);
        Timer timer1 = new Timer();
        timer1.schedule(new Robot(),0,3000);
    }


    /** Method for starting the simulation */
    public void start(){

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
