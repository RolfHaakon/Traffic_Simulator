import java.util.TimerTask;
/** The Robot class changes the traffic light state */
public class Robot {

    // TODO Robot is currently reset every time the user starts or stops the program
    static boolean TL1;


    public boolean change(boolean state) {
        if (state == false) {
            TL1 = false;
            state = true;
        }
        else if (state == true){
            TL1 = true;
            state = false;
        }
        return state;
    }

}
