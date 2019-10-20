import java.awt.*;

public class Bus extends Vehicle {

    public Bus(int newx, int newy){
        super(newx,newy);
        length = 30;
        width = 5;
        speed = 5;
    }


    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x,y,length,width);
    }

}
