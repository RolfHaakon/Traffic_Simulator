import java.awt.*;

public class Bus extends Vehicle {

    public Bus(int x, int y, int roadID){
        super(x,y,roadID);
        length = 20;
        width = 5;
        speed = 4;

    }


    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x,y,length,width);
    }

}
