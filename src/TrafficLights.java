import java.awt.*;

public class TrafficLights {
    int x;
    int y;
    private int roadID;
    boolean running;


    TrafficLights(int x, int y, int roadID, boolean running){
        this.x = x;
        this.y = y;
        this.roadID = roadID;
        this.running = running;

    }

    public void paint(Graphics g){

    }

    boolean isRunning() {
        return running;
    }

    void setRunning(boolean running) {
        this.running = running;
    }
}
