import java.awt.*;

public class xRoads {

    int x1;
    int y1;
    int x2;
    int y2;
    int id;


    public xRoads(int x1 ,int y1, int x2, int y2, int id){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.id = id;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(x1,y1,x2,y2);
    }

}
