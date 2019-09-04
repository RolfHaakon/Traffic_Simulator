import java.util.TimerTask;

public class Robot {

    static boolean TL1;


    public boolean change(boolean state) {
        if (state == false) {
            TL1 = false;
            System.out.println("Robot turned TL1: Red");
            state = true;
        }
        else if (state == true){
            TL1 = true;
            System.out.println("Robot turned TL1: Green");
            state = false;
        }
        return state;
    }

}
