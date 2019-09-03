import java.util.TimerTask;

public class Robot extends TimerTask {
    private int canDrive;

    public Robot() {
        this.canDrive = 0;
    }

    @Override
    public void run() {
        System.out.println("Initial traffic light "+ getCanDrive());
        if (getCanDrive() == 0) {
            setCanDrive(1);
            System.out.println("Traffic light: Green");
        }
        else if (getCanDrive() == 1){
            setCanDrive(0);
            System.out.println("Traffic light: Red");
        }
    }

    public int getCanDrive() {
        return canDrive;
    }

    public void setCanDrive(int canDrive) {
        this.canDrive = canDrive;
    }
}
