import java.awt.*;

public class TrafficLightsList extends TrafficLights {
    private int roadID;
    private int isX;

    TrafficLightsList(int x, int y, int roadID, boolean running, int isX) {
        super(x, y, roadID, running);
        this.running = running;
        this.roadID = roadID;
        this.isX = isX;
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
