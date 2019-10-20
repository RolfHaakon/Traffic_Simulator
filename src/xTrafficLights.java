import java.awt.*;

public class xTrafficLights extends TrafficLights {
    boolean running;

    public xTrafficLights(int x, int y,boolean running) {
        super(x, y);
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
