import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    public void testDefault() {
        Road road = new Road(3,5);
        assertEquals(3,road.road0Length);
        assertEquals(5, road.road1Length);
    }


}