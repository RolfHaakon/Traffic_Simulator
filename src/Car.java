import java.awt.*;

public class Car extends Vehicle {

    public Car(int x, int y,int roadID){
        super(x,y,roadID);
        length = 10;
        width = 5;
        speed = 4;
    }


    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,length,width);
    }

}
