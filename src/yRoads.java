import java.awt.*;

public class yRoads {

    int x1;
    int y1;
    int x2;
    int y2;
    int roadID;


    public yRoads(int x1 ,int y1, int x2, int y2, int roadID){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.roadID = roadID;
    }





    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(x1,y1,x2,y2);
    }



}
