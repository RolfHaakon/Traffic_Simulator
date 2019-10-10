import java.awt.*;
import java.util.Timer;

public class Main {
    String fileName = "Untitled";
    private Timer timer = new Timer();
    private boolean firstStart = true;

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    /** Method for starting the simulation */
    public void start(){
        if (firstStart) {
            System.out.println("\nThe car will drive down Road 1, wait for the traffic light to turn green" +
                    "before continuing down road 2. After reaching the end of road 2 the car will start from the beginning\n");
            this.timer = new Timer();
            this.timer.schedule(new Pulse(),0,1000/24);
            firstStart = false;
        }
        else {
            resume();
        }
    }
    /** Method for pause the simulation */
    public void pause(){
        this.timer.cancel();
    }
    /** Method for resuming the simulation */
    public void resume() {
        this.timer = new Timer();
        this.timer.schedule(new Pulse(),0,1000);
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
