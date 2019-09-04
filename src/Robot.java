import java.util.TimerTask;

public class Robot {

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
