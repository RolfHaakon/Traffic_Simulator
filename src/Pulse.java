import java.util.TimerTask;

public class Pulse extends TimerTask {

    private int ticker = 0;
    private boolean robotState = false;
    //int carPos;


    @Override
    public void run() {
        ticker = ticker + 1;
        if (ticker > 4) {
            robotState = changeLight();
            ticker = 0;
        }
        //carPos = carMovement();
        carMovement();
    }


    private boolean changeLight(){
        Robot robot = new Robot();
        return robot.change(robotState);
    }

    private void carMovement(){
        Car car = new Car();
        car.moveForward();
    }
}