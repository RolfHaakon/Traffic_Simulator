import java.awt.*;

public class Car extends Vehicle {

    public Car(int x, int y){
        super(x,y);
        length = 10;
        width = 5;
        speed = 5;
    }


    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,length,width);
    }

}
