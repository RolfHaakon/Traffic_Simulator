import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @Test
    void getSpeed() {
        Car car = new Car(1,1);
        assertEquals(1,car.getSpeed());
    }

    @Test
    void setSpeed() {
        Car car = new Car(1,1);
        car.setSpeed(2);
        assertEquals(2,car.getSpeed());
    }

    @Test
    void start() {
        Car car = new Car(1,0);
        car.start();
        assertEquals(1,car.getSpeed());
    }

    @Test
    void stop() {
        Car car = new Car(1,1);
        car.stop();
        assertEquals(0,car.getSpeed());
    }
}