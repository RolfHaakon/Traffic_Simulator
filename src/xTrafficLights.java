import java.awt.*;

public class xTrafficLights extends TrafficLights {
    boolean running;
    int roadID;

    public xTrafficLights(int x, int y,int roadID,boolean running) {
        super(x, y, roadID, running);
        this.running = running;
        this.roadID = roadID;
        this.running = running;
    }

    public void paint(Graphics g){
        if (running){
            g.setColor(Color.GREEN);
        }
        if (!running){
            g.setColor(Color.RED);
        }
        g.fillRect(x,y,5,5);
    }

}
