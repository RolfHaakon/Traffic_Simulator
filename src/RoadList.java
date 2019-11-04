import java.awt.*;

public class RoadList {

    int x1;
    int y1;
    int x2;
    int y2;
    int roadID;
    boolean isX;


    public RoadList(int x1 , int y1, int x2, int y2, int roadID, boolean isX){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.roadID = roadID;
        this.isX = isX;
    }





    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(x1,y1,x2,y2);
    }
}
